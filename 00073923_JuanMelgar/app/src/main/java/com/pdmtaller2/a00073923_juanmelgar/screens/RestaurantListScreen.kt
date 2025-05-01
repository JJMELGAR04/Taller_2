package com.pdmtaller2.a00073923_juanmelgar.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.pdmtaller2.a00073923_juanmelgar.data.restaurants
import kotlinx.serialization.json.Json

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantListScreen(navController: NavController) {
    val categories = restaurants.flatMap { it.categories }.distinct()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Restaurantes") }) },
        bottomBar = { BottomBar(navController) } // Añadir BottomBar aquí
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding).padding(16.dp)) {
            categories.forEach { category ->
                item {
                    Text(category, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(8.dp))

                    val filtered = restaurants.filter { it.categories.contains(category) }

                    LazyRow {
                        items(filtered.size) { index ->
                            val restaurant = filtered[index]
                            Card(
                                modifier = Modifier
                                    .padding(end = 8.dp)
                                    .width(200.dp)
                            ) {
                                Column(modifier = Modifier.padding(8.dp)) {
                                    Image(
                                        painter = painterResource(id = restaurant.imageResId),
                                        contentDescription = null,
                                        modifier = Modifier.height(100.dp),
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(restaurant.name, fontWeight = FontWeight.Bold)
                                    Button(onClick = {
                                        navController.navigate("menu/${restaurant.id}")
                                    }) {
                                        Text("Ver menú")
                                    }
                                }
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                }
            }
        }
    }
}