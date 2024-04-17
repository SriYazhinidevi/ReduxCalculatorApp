package com.example.reduxcalculatorapp.viewmodel

import android.os.Environment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxcalculatorapp.redux.applyMiddleware
import com.example.reduxcalculatorapp.redux.combineReducers
import com.example.reduxcalculatorapp.redux.createStoreAny
import com.example.reduxcalculatorapp.redux.reducer.HomeReducer
import com.example.reduxcalculatorapp.state.HomeEnvironment
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(environment: HomeEnvironment) : ViewModel() {
    val loginStore = createStoreAny(
        initialState = environment.initialState,
        enhancer = applyMiddleware(
            environment.getMiddleware(viewModelScope)
        ),
        reducer = combineReducers(HomeReducer)
    )
}