package com.shhatrat.examplefeature

//import com.shhatrat.cpp.HelloWorld
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.google.android.gms.wearable.*
import com.shhatrat.base.useCase.view.NoInternetConnection
import com.shhatrat.base.useCase.view.NoInternetConnectionImpl
import com.shhatrat.base.view.BaseActivity
import com.shhatrat.cpp.ICppManager
import com.shhatrat.examplefeature.databinding.ActivityFeatureBinding
import com.shhatrat.model.Joke
import org.koin.android.ext.android.inject

class FeatureActivity :
    BaseActivity<IFeatureContract.P, IFeatureContract.V, ActivityFeatureBinding, FeatureNavigator>(),
    IFeatureContract.V,  DataClient.OnDataChangedListener {

    override val noInternetConnection: NoInternetConnection by lazy {
        NoInternetConnectionImpl(getContext())
    }

    override val presenter: IFeatureContract.P by inject()

    val cppManager: ICppManager by inject()

    override fun getLayoutResId(): Int = R.layout.activity_feature

    override fun getMvpView(): IFeatureContract.V = this

    override fun showJoke(joke: Joke) {
        Toast.makeText(this, joke.joke, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        withBinding {
            button.setOnClickListener {
                Log.d("cpp", cppManager.printHello())
            }
        }
        Wearable.getDataClient(this).addListener(this)
    }

    override fun attachViewBinding(layoutInflater: LayoutInflater) =
        ActivityFeatureBinding.inflate(layoutInflater)

    override val navigator: FeatureNavigator by inject()

    override fun onDataChanged(dataEvents: DataEventBuffer) {
        dataEvents.forEach { event ->
            // DataItem changed
            if (event.type == DataEvent.TYPE_CHANGED) {
                event.dataItem.also { item ->
                    if (item.uri.path?.compareTo("/count") == 0) {
                        DataMapItem.fromDataItem(item).dataMap.apply {
                            Log.d("XDDDD",  "---> ${getInt("KEY")}")
                        }
                    }
                }
            } else if (event.type == DataEvent.TYPE_DELETED) {
                Log.d("XDDDD",  "---> :( ")
            }
        }
    }
}