package com.example.boardingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bordingapp.viewModel.MainViewBording
import com.example.bordingapp.views.HomeView
import com.example.bordingapp.dataStore.StoreBording

@Composable
fun NavManager() {
    val context = LocalContext.current
    val dataStore = StoreBording(context)
    val store by dataStore.getStoreBording.collectAsState(initial = false)
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = if (store) "home" else "onBoarding"
    ) {
        composable("onBoarding") {
            MainViewBording(navController, dataStore)
        }
        composable("home") {
            HomeView(navController)
        }
    }
}
