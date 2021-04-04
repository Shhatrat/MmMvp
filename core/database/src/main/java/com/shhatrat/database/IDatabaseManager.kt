package com.shhatrat.database

import com.shhatrat.model.Joke

interface IDatabaseManager : IDatabaseActions<Convertable<Joke, Any>>//, IRxDatabaseActions<Joke>