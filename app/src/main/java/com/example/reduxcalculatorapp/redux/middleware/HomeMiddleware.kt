package com.example.reduxcalculatorapp.redux.middleware

import com.example.reduxcalculatorapp.network.repositories.HomeRepository
import com.example.reduxcalculatorapp.redux.Middleware
import com.example.reduxcalculatorapp.redux.createMiddleware
import com.example.reduxcalculatorapp.state.HomeActions
import kotlinx.coroutines.CoroutineScope

fun createHomeMiddleware(
    repository: HomeRepository,
    scope: CoroutineScope
) : Middleware<Any> {
    return createMiddleware { store, next, action ->
        next(action)

        when(action) {
//            is HomeActions.LoadPhotos -> loadPhotos(store,repository,scope)
            else -> {}
        }
    }
}
