package com.example.bordingapp.viewModel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

import com.example.bordingapp.R
import com.example.bordingapp.data.PageData
import com.example.bordingapp.dataStore.StoreBording
import com.example.bordingapp.onBoardViews.OnBoardingPager
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainViewBoarding(navController: NavController, store : StoreBording){
    val items=ArrayList<PageData>()

    items.add(
        PageData(
            "Bienvenidos!!",
            "Bienvenidos a la aplicación para mostrar el uso del onBoarding",
            R.raw.page1,
        )
    )
    items.add(
        PageData(
            "Uso de onBoarding",
            "Esta es la segunda pagina del Boarding mostrando una descripcion",
            R.raw.page2,
        )
    )
    items.add(
        PageData(
            "Fin de Boarding!!",
            "Esta es la pagina final del onBoarding y ya deberia apareer el boton.",
            R.raw.page3,
        )
    )

    val pagerState= rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(item = items, pagerState = pagerState, modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.White),
        navController = navController,
        store = store
    )

}