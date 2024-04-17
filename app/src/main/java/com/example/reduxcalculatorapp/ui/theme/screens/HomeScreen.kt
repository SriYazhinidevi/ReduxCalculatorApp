package com.example.reduxcalculatorapp.ui.theme.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reduxcalculatorapp.R
import com.example.reduxcalculatorapp.navigation.AppNavRoutes
import com.example.reduxcalculatorapp.viewmodel.HomeViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = username.value,
            placeholder = {
                Text(text = stringResource(R.string.username))
            },
            onValueChange = { updatedUsername ->
                viewModel.loginStore.dispatch(LoginActions.UpdateUsername(updatedUsername))
            },
            modifier = Modifier
                .padding(vertical = size_20)
                .align(Alignment.CenterHorizontally)
        )

        TextField(
            value = password.value,
            placeholder = {
                Text(text = stringResource(R.string.password))
            },
            onValueChange = { updatedPassword ->
                viewModel.loginStore.dispatch(LoginActions.UpdatePassword(updatedPassword))
            },
            modifier = Modifier
                .padding(vertical = size_20)
                .align(Alignment.CenterHorizontally),
            visualTransformation = PasswordVisualTransformation()
        )

        if (!isLoading.value && !isLoggedIn.value) {
            Button(
                onClick = {
                    viewModel.loginStore.dispatch(
                        LoginActions.Login(
                            AuthRequestModel(
                                username = username.value,
                                password = password.value
                            )
                        )
                    )
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text(text = stringResource(R.string.login))
            }
        } else {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
        }

        if (isLoggedIn.value) {
            navController.navigate(AppNavRoutes.HOME.name)
        }

    }

}