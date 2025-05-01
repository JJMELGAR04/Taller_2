package com.pdmtaller2.a00073923_juanmelgar.Navigation

import kotlinx.serialization.Serializable

@Serializable
object RestaurantListScreen

@Serializable
data class RestaurantMenu(val restaurantId: Int)

@Serializable
object OrdersScreen

object Routes {
    const val RestaurantList = "restaurant_list_screen"
    const val RestaurantMenu = "menu/{restaurant}"
    const val SearchScreen = "search_screen"
    const val Orders = "orders"
    const val MainScreen = "main_screen"
}