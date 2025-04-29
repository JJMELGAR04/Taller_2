package com.pdmtaller2_a0007._3923_juanmelgar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import com.pdmtaller2.a00073923_juanmelgar.Models.restaurants
import com.pdmtaller2.a00073923_juanmelgar.Navigation.RestaurantMenuScreen

@Composable
fun ListaRestaurante(navController: NavController) {
    val categories = restaurants.flatMap { it.categories }.distinct()
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        categories.forEach { category ->
            item {
                Text(category, fontWeight = FontWeight.Bold)
                LazyRow {
                    items(restaurants.filter { it.categories.contains(category) }) { restaurant ->
                        Card(
                            modifier = Modifier
                                .padding(end = 8.dp)
                                .width(200.dp)
                        ) {
                            Column(modifier = Modifier.padding(8.dp)) {
                                Image(
                                    painter = rememberAsyncImagePainter(restaurant.imageUrl),
                                    contentDescription = null,
                                    modifier = Modifier.height(120.dp),
                                    contentScale = ContentScale.Crop
                                )
                                Text(restaurant.name)
                                Button(onClick = {
                                    val route = Json.encodeToString(RestaurantMenuScreen(restaurant.id))
                                    navController.navigate(route)
                                }) {
                                    Text("Ver menú")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
