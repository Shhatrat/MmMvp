package com.shhatrat.realm

import com.shhatrat.action.rx.RealmRxActionImpl
import com.shhatrat.action.rx.RealmRxActions
import com.shhatrat.action.simple.RealmActionImpl
import com.shhatrat.action.simple.RealmActions
import com.shhatrat.model.RealmJoke

class DatabaseManager : IDatabaseManager,
    RealmActions<RealmJoke> by RealmActionImpl(),
    RealmRxActions<RealmJoke> by RealmRxActionImpl()