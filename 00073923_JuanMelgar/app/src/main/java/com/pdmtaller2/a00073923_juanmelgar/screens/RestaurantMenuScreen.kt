package com.pdmtaller2.a00073923_juanmelgar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.a00073923_juanmelgar.Component.BottomBar
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel
import com.pdmtaller2.a00073923_juanmelgar.data.restaurants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantMenuScreen(
    restaurantId: Int,
    navController: NavController,
    cartViewModel: CartViewModel
) {
    val restaurant = restaurants.find { it.id == restaurantId }

    if (restaurant == null) {
        // Si no se encuentra el restaurante, mostrar un mensaje
        Text("Restaurante no encontrado")
        return
    }

    Scaffold(
        topBar = { TopAppBar(title = { Text(restaurant.name) }) },
        bottomBar = { BottomBar(navController) } // Añadir BottomBar aquí
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text(restaurant.description)
            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar los platillos del menú
            restaurant.menu.forEach { dish ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        // Mostrar imagen del platillo
                        Image(
                            painter = painterResource(id = dish.imageResId),
                            contentDescription = null,
                            modifier = Modifier.size(100.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(Modifier.width(8.dp))

                        // Información del platillo
                        Column {
                            Text(
                                text = dish.name,
                                style = MaterialTheme.typography.titleMedium,
                                fontWeight = FontWeight.Bold
                            )
                            Text(text = dish.description)
                            Spacer(modifier = Modifier.height(8.dp))

                            // Botón para agregar al carrito
                            Button(onClick = {
                                cartViewModel.addDish(dish)
                            }) {
                                Text("Agregar al carrito")
                            }
                        }
                    }
                }
            }
        }
    }
}