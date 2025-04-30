package com.pdmtaller2.a00073923_juanmelgar.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
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

@Composable
fun AppNavigation(cartViewModel: CartViewModel, modifier: Modifier = Modifier) {
    // Controlador de navegación
    val navController = rememberNavController()

    // Configuración de rutas
    NavHost(
        navController = navController,
        startDestination = Routes.RestaurantList
    ) {
        // Pantalla de la lista de restaurantes
        composable(Routes.RestaurantList) {
            RestaurantListScreen(navController) // Pantalla con la lista de restaurantes
        }

        // Menú del restaurante
        composable(
            route = Routes.RestaurantMenu,
            arguments = listOf(navArgument("restaurant") { type = NavType.StringType })
        ) { backStackEntry ->
            val json = backStackEntry.arguments?.getString("restaurant")
            val screen = Json.decodeFromString<RestaurantMenuScreen>(json!!)
            RestaurantMenuScreen(screen.restaurantId, navController, cartViewModel)
        }

        // Pantalla de las órdenes
        composable(Routes.Orders) {
            OrdersScreen(cartViewModel, navController)
        }
    }
}