package com.shhatrat.database

import com.shhatrat.database.actions.IDatabaseActions
import com.shhatrat.database.actions.IRxDatabaseActions
import com.shhatrat.model.Joke

interface IDatabaseManager : IDatabaseActions<Joke>, IRxDatabaseActions<Joke>