package com.example.reduxcalculatorapp.state

import com.example.reduxcalculatorapp.redux.Middleware
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope

interface HomeEnvironment {
    val initialState: HomeState

    val globalMiddleware: List<Middleware<Any>>

    val dispatcher: CoroutineDispatcher

    fun getMiddleware(coroutineScope: CoroutineScope) : List<Middleware<Any>>
}