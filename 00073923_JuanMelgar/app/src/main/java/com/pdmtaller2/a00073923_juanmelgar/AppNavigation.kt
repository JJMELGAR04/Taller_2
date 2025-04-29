package com.pdmtaller2.a00073923_juanmelgar

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel
import com.pdmtaller2_a00073923_juanmelgar.Component.BottomBar
import com.pdmtaller2_a00073923_juanmelgar.screens.*
import com.pdmtaller2_a00073923_juanmelgar.viewmodel.CartViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import com.pdmtaller2.a00073923_juanmelgar.Navigation.OrdersScreen
import kotlinx.serialization.json.Json
import com.pdmtaller2_a0007._3923_juanmelgar.Component.BottomBar
import com.pdmtaller2.a00073923_juanmelgar.Navigation.RestaurantListScreen
import com.pdmtaller2.a00073923_juanmelgar.Navigation.RestaurantMenuScreen
import com.pdmtaller2.a00073923_juanmelgar.Navigation.SearchScreen
import com.pdmtaller2_a0007._3923_juanmelgar.screens.ListaRestaurante
import com.pdmtaller2_a0007._3923_juanmelgar.screens.MenuRestaurante

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    val cartViewModel: CartViewModel = viewModel()

    Scaffold(bottomBar = { BottomBar(navController) }) { padding ->
        NavHost(navController = navController, startDestination = Json.encodeToString(RestaurantListScreen)) {
            composable(Json.encodeToString(RestaurantListScreen)) {
                ListaRestaurante(navController)
            }
            composable("{restaurantMenu}") { backStackEntry ->
                val arg = backStackEntry.arguments?.getString("restaurantMenu") ?: return@composable
                val screen = Json.decodeFromString<RestaurantMenuScreen>(arg)
                MenuRestaurante(screen.restaurantId, navController, cartViewModel)
            }
            composable(Json.encodeToString(SearchScreen)) {
                Text("Pantalla de búsqueda")
            }
            composable(Json.encodeToString(OrdersScreen)) {
                MisOrdenes(cartViewModel)
            }
        }
    }
}