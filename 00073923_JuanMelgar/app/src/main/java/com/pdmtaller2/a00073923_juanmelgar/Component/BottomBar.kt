package com.pdmtaller2.a00073923_juanmelgar.Component

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.navigation.NavController
import androidx.compose.material.icons.filled.Menu

@Composable
fun BottomBar(navController: NavController) {
    val items = listOf("restaurant", "search", "orders")
    NavigationBar {
        items.forEach { screen ->
            NavigationBarItem(
                selected = false,
                onClick = { navController.navigate(screen) },
                icon = { Icon(Icons.Default.Menu, contentDescription = screen) },
                label = { Text(screen.replaceFirstChar { it.uppercase() }) }
            )
        }
    }
}
