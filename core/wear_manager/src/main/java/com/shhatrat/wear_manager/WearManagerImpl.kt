package com.shhatrat.wear_manager

import android.content.Context
import com.google.gson.Gson
import com.shhatrat.model.Joke
import com.shhatrat.wear_manager.action.IWearAction
import com.shhatrat.wear_manager.action.WearActionImpl

class WearManagerImpl(
    private val context: Context,
    private val gson: Gson
) : IWearManager,
    IWearAction<Joke> by WearActionImpl(context, gson, "/joke", "JOKE", Joke::class.java)