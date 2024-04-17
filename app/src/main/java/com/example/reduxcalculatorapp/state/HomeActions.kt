package com.example.reduxcalculatorapp.state

interface HomeActions {
    data class Login() : HomeActions

    data class LoginResult(val isLoggedIn: Boolean) : HomeActions

    data class UpdateUsername(val username: String) : HomeActions

    data class UpdatePassword(val password: String) : HomeActions
}