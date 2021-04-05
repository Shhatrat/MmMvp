package com.shhatrat.realm

import com.shhatrat.actionsImpl.IDatabaseActionsImpl
import com.shhatrat.actionsImpl.IRxDatabaseActionsImpl
import com.shhatrat.database.IDatabaseActions
import com.shhatrat.database.IDatabaseManager
import com.shhatrat.database.IRxDatabaseActions
import com.shhatrat.model.Joke
import com.shhatrat.model.RealmJoke
import com.shhatrat.model.RealmJoke.Companion.fromRealm
import com.shhatrat.model.RealmJoke.Companion.toRealm

class DatabaseManager : IDatabaseManager,
    IDatabaseActions<Joke> by IDatabaseActionsImpl(
        { data -> data.toRealm() },
        { realmJoke -> (realmJoke as RealmJoke).fromRealm() },
        RealmJoke.getNameOfPrimaryKey(),
        RealmJoke::class
    ),
    IRxDatabaseActions<Joke> by IRxDatabaseActionsImpl(
        { realmJoke -> (realmJoke as RealmJoke).fromRealm() },
        RealmJoke::class
    )