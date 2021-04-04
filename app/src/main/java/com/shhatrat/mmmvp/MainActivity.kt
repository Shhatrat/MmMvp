package com.shhatrat.mmmvp

//import com.shhatrat.examplefeature.FeatureActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.setOnClickListener {
//            startActivity(Intent(this, FeatureActivity::class.java))
        }
    }
}