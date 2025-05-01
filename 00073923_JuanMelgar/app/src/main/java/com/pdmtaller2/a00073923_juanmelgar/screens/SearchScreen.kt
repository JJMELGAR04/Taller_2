package com.pdmtaller2.a00073923_juanmelgar.screens

import android.R.attr.padding
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pdmtaller2.a00073923_juanmelgar.Component.BottomBar
import com.pdmtaller2.a00073923_juanmelgar.Models.Dish
import com.pdmtaller2.a00073923_juanmelgar.ViewModel.CartViewModel
import com.pdmtaller2.a00073923_juanmelgar.data.restaurants
import kotlin.collections.find

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController, cartViewModel: CartViewModel) {

    val query = remember { mutableStateOf(TextFieldValue("")) }

    // Filtrar los platillos que coincidan con el texto de búsqueda
    val filteredDishes = remember(query.value.text) {
        restaurants.flatMap { it.menu }  // Obtener todos los platillos de los restaurantes
            .filter { it.name.contains(query.value.text, ignoreCase = true) }  // Filtrar por nombre
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Buscar Platillos") })
        },
        bottomBar = { BottomBar(navController) }
    ) { padding ->

        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            // Campo de búsqueda
            TextField(
                value = query.value,
                onValueChange = { query.value = it },
                label = { Text("Buscar Platillo") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar los resultados de la búsqueda
            if (filteredDishes.isEmpty()) {
                Text("No se encontraron resultados.")
            } else {
                LazyColumn {
                    items(filteredDishes) { dish ->
                        // Mostrar cada platillo encontrado
                        SearchResultItem(dish, cartViewModel, navController)
                    }
                }
            }
        }
    }
}

@Composable
fun SearchResultItem(
    dish: Dish,
    cartViewModel: CartViewModel,
    navController: NavController
) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
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
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = dish.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                Text(text = dish.description)

                // Botón para agregar al carrito
                Button(onClick = {
                    cartViewModel.addDish(dish)
                    Toast.makeText(navController.context, "${dish.name} agregado al carrito", Toast.LENGTH_SHORT).show()
                }) {
                    Text("Agregar al carrito")
                }
            }
        }
    }
}