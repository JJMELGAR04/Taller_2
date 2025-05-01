package com.pdmtaller2.a00073923_juanmelgar.Component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.navigation.compose.currentBackStackEntryAsState
import com.pdmtaller2.a00073923_juanmelgar.Navigation.Routes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(navController: NavController) {

    val navBackStackEntry = navController.currentBackStackEntryAsState()

    // Comprobar cuál es la pantalla actual para marcarla como seleccionada
    NavigationBar {
        // Item para la pantalla de lista de restaurantes
        NavigationBarItem(
            selected = navBackStackEntry.value?.destination?.route == Routes.RestaurantList,
            onClick = { navController.navigate(Routes.RestaurantList) },
            icon = { Icon(Icons.Default.Home, contentDescription = "Lista de Restaurantes") },
            label = { Text("Restaurantes") }
        )

        // Item para la pantalla de búsqueda
        NavigationBarItem(
            selected = navBackStackEntry.value?.destination?.route == Routes.SearchScreen,  // Nueva ruta para buscar
            onClick = { navController.navigate(Routes.SearchScreen) }, // Navegar a la pantalla de búsqueda
            icon = { Icon(Icons.Default.Search, contentDescription = "Buscar") },
            label = { Text("Buscar") }
        )

        // Item para la pantalla de órdenes
        NavigationBarItem(
            selected = navBackStackEntry.value?.destination?.route == Routes.Orders,
            onClick = { navController.navigate(Routes.Orders) },
            icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Mis Órdenes") },
            label = { Text("Órdenes") }
        )
    }
}
