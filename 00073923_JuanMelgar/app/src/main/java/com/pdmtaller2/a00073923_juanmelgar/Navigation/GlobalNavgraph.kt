package com.pdmtaller2.a00073923_juanmelgar.Navigation

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel
import com.pdmtaller2.a00073923_juanmelgar.screens.MainScreen
import com.pdmtaller2.a00073923_juanmelgar.screens.RestaurantMenuScreen

fun NavGraphBuilder.mainNavGraph(
    navController: NavHostController,
    viewModel: CartViewModel
){
    navigation(
        route = HOME_ROUTE,
        startDestination = Routes.RestaurantList
    ){
        composable(Routes.MainScreen){
            MainScreen(navController, viewModel)
        }

        composable(Routes.RestaurantMenu) {
            val restaurantId = it.arguments?.getString("restaurant")?.toInt() ?: 0
            RestaurantMenuScreen(restaurantId,navController, viewModel)
        }
    }
}