package com.shhatrat.datastore

import com.shhatrat.datastore.action.DataStoreAction

interface DataStoreManager {

    val titleAction: DataStoreAction<String>
}