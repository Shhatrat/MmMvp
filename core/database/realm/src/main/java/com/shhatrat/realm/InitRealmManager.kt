package com.shhatrat.realm

import android.content.Context
import com.shhatrat.base.manager.ManagerInit
import io.realm.DynamicRealm
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration

class InitRealmManager constructor(private val context: Context) : ManagerInit {

    companion object {
        private const val DB_VERSION = 1L
    }

    override fun init() {
        Realm.init(context)
        Realm.setDefaultConfiguration(getConfiguration())
    }

    private fun getConfiguration(): RealmConfiguration {
        return RealmConfiguration.Builder()
            .schemaVersion(DB_VERSION)
            .allowWritesOnUiThread(true)
            .migration(Migration())
            .build()

    }

    class Migration : RealmMigration {
        override fun migrate(realm: DynamicRealm, oldVersion: Long, newVersion: Long) {
            //todo add here migrations
        }
    }
}