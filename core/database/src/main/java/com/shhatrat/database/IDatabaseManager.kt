package com.shhatrat.database

import com.shhatrat.model.Joke

interface IDatabaseManager : IDatabaseActions<Joke>, IRxDatabaseActions<Joke>