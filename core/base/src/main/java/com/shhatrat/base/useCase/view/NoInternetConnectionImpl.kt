package com.shhatrat.base.useCase.view

import android.content.Context
import android.widget.Toast

class NoInternetConnectionImpl(private val context: Context?) : NoInternetConnection {

    override fun noInternetConnectionTooltip(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}