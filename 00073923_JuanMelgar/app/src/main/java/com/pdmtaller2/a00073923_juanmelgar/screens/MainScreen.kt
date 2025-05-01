package com.pdmtaller2.a00073923_juanmelgar.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.pdmtaller2.a00073923_juanmelgar.Component.BottomBar
import com.pdmtaller2.a00073923_juanmelgar.Navigation.AppNavigation
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel

@Composable
fun MainScreen(navController: NavHostController, cartViewModel: CartViewModel) {
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ){
        AppNavigation(navController, modifier = Modifier.padding(it),cartViewModel )
    }
}