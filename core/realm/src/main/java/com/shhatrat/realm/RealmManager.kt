package com.shhatrat.realm

import android.content.Context
import com.shhatrat.base.manager.ManagerInit
import io.realm.Realm

class RealmManager constructor(private val context: Context) : ManagerInit {

    override fun init() {
        Realm.init(context)
    }
}