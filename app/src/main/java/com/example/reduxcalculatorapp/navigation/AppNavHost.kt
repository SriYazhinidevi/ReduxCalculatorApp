package com.example.reduxcalculatorapp.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reduxcalculatorapp.ui.theme.screens.HomeScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavHost() {
    Scaffold() { innerPadding ->

        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = AppNavRoutes.HOME.name,
            modifier = Modifier.padding(innerPadding)
        ) {

//            composable(
//                route = AppNavRoutes.LOGIN.name
//            ) {
//                LoginScreen(navController = navController)
//            }

            composable(route = AppNavRoutes.HOME.name) {
                HomeScreen()
            }

        }
    }
}