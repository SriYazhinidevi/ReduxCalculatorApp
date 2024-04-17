package com.example.reduxcalculatorapp.redux.reducer

import com.example.reduxcalculatorapp.redux.Reducer
import com.example.reduxcalculatorapp.redux.reducerForActionType
import com.example.reduxcalculatorapp.state.HomeActions
import com.example.reduxcalculatorapp.state.HomeState

val HomeReducer : Reducer<HomeState> = reducerForActionType<HomeState, HomeActions> { state, action ->
    when(action) {

    }
}

val loginReducer : Reducer<LoginState> = reducerForActionType<LoginState,LoginActions> { state, action ->
    when(action) {
        is LoginActions.Login -> login(state)
        is LoginActions.LoginResult -> loginresult(state,action)
        is LoginActions.UpdateUsername -> updateUsername(state,action)
        is LoginActions.UpdatePassword -> updatePassword(state,action)
    }
}