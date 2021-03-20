package com.shhatrat.realm

import com.shhatrat.action.rx.RealmRxActions
import com.shhatrat.action.simple.RealmActions
import com.shhatrat.model.RealmJoke

interface IDatabaseManager : RealmActions<RealmJoke>, RealmRxActions<RealmJoke>