package com.pdmtaller2_a0007._3923_juanmelgar.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.pdmtaller2_a0007._3923_juanmelgar.Component.BottomBar
import com.pdmtaller2.a00073923_juanmelgar.Models.restaurants
import com. pdmtaller2.a00073923_juanmelgar. ViewModel.CartViewModel

@Composable
fun MenuRestaurante(restaurantId: Int, navController: NavController, cartViewModel: CartViewModel) {
    val restaurant = restaurants.find { it.id == restaurantId } ?: return
    var search by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text(restaurant.name) }) },
        bottomBar = { BottomBar(navController) }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)) {
            TextField(value = search, onValueChange = { search = it }, label = { Text("Buscar platillo") })
            Spacer(modifier = Modifier.height(16.dp))
            restaurant.menu.filter { it.name.contains(search, true) }.forEach { dish ->
                Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(dish.imageUrl),
                            contentDescription = null,
                            modifier = Modifier.size(64.dp)
                        )
                        Spacer(Modifier.width(8.dp))
                        Column {
                            Text(dish.name, fontWeight = FontWeight.Bold)
                            Text(dish.description)
                            Button(onClick = {
                                cartViewModel.addToCart(dish)
                                Toast.makeText(LocalContext.current, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
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
