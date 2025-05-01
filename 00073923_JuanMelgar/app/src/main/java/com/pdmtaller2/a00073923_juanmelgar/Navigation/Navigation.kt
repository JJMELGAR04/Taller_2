package com.pdmtaller2.a00073923_juanmelgar.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel
import com.pdmtaller2.a00073923_juanmelgar.screens.RestaurantListScreen
import kotlinx.serialization.json.Json
import com.pdmtaller2.a00073923_juanmelgar.screens.OrdersScreen
import com.pdmtaller2.a00073923_juanmelgar.screens.RestaurantMenuScreen
import com.pdmtaller2.a00073923_juanmelgar.screens.SearchScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier, cartViewModel: CartViewModel) {
    // Configuración de rutas
    NavHost(
        navController = navController,
        startDestination = Routes.RestaurantList
    ) {
        // Pantalla de la lista de restaurantes
        composable(Routes.RestaurantList) {
            RestaurantListScreen(navController) // Pantalla con la lista de restaurantes
        }

        // Pantalla de las órdenes
        composable(Routes.Orders) {
            OrdersScreen(cartViewModel, navController)
        }

        composable(Routes.SearchScreen) {
            SearchScreen(navController, cartViewModel)
        }

        mainNavGraph(navController = navController, viewModel = cartViewModel)
    }
}

const val HOME_ROUTE = "home"