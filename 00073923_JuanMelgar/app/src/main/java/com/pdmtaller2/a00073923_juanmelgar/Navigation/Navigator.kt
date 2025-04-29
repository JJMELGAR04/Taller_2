package com.pdmtaller2.a00073923_juanmelgar.Navigation

import kotlinx.serialization.Serializable

@Serializable object RestaurantListScreen
@Serializable data class RestaurantMenuScreen(val restaurantId: Int)
@Serializable object SearchScreen
@Serializable object OrdersScreen