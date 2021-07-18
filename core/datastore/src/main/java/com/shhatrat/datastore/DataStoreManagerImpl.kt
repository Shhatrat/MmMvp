package com.shhatrat.datastore

import android.content.Context
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.rxjava3.rxPreferencesDataStore
import com.shhatrat.datastore.action.DataStoreAction
import com.shhatrat.datastore.action.DataStoreActionImpl

class DataStoreManagerImpl constructor(private val context: Context) :
    BaseDataStoreManagerImpl(context),
    DataStoreManager {

    override val Context.myRxDataStore by rxPreferencesDataStore("filename")

    private val TITLE_KEY by lazy { stringPreferencesKey("title_key") }

    override val titleAction: DataStoreAction<String> by lazy { DataStoreActionImpl(context.myRxDataStore,TITLE_KEY) }
}