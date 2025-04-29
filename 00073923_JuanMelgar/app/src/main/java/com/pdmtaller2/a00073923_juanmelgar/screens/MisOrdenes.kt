package com.pdmtaller2.a00073923_juanmelgar.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pdmtaller2_a00073923_juanmelgar.Component.BottomBar
import com.pdmtaller2_a00073923_juanmelgar.viewmodel.CartViewModel

@Composable
fun MisOrdenes(cartViewModel: CartViewModel) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mis órdenes") }) },
        bottomBar = { BottomBar(navController = androidx.navigation.compose.rememberNavController()) }
    ) { padding ->
        Column(Modifier.padding(padding).fillMaxSize().padding(16.dp)) {
            if (cartViewModel.cartItems.isEmpty()) {
                Text("no se encontraron resultados")
            } else {
                cartViewModel.cartItems.forEach { dish ->
                    Text("• ${dish.name}")
                }
            }
        }
    }
}
