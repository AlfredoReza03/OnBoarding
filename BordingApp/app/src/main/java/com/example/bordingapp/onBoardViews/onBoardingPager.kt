package com.example.bordingapp.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.bordingapp.data.PageData
import com.example.bordingapp.dataStore.StoreBording
import com.example.bordingapp.onBoardViews.OnBoardingPager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainViewBoarding(navController: NavController, store: StoreBording) {
    val items = listOf(
        PageData("Bienvenidos!!", "Bienvenidos a la aplicación para mostrar el uso del onBoarding", R.raw.page1),
        PageData("Uso de onBoarding", "Esta es la segunda página del Boarding mostrando una descripción", R.raw.page2),
        PageData("Fin de Boarding!!", "Esta es la página final del onBoarding y ya debería aparecer el botón.", R.raw.page3)
    )

    val pagerState = rememberPagerState()

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White),
        navController = navController,
        store = store
    )
}