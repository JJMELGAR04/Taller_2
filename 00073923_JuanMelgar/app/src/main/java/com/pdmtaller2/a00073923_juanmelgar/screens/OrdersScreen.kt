package com.pdmtaller2.a00073923_juanmelgar.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.a00073923_juanmelgar.Component.BottomBar
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrdersScreen(cartViewModel: CartViewModel, navController: NavController) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mis Órdenes") }) },
        bottomBar = { BottomBar(navController = navController) } // Añadir BottomBar aquí
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            if (cartViewModel.cartItems.isEmpty()) {
                Text("No se han agregado platillos al carrito.")
            } else {
                // Mostrar cada platillo en el carrito
                cartViewModel.cartItems.forEach { dish ->
                    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(dish.name, style = MaterialTheme.typography.titleMedium)
                            Text(dish.description)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Botón para vaciar el carrito
                Button(onClick = { cartViewModel.clearCart() }) {
                    Text("Vaciar carrito")
                }
            }
        }
    }
}