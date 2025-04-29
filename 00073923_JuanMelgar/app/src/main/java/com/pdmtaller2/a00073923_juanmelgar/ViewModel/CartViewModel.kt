package com.pdmtaller2.a00073923_juanmelgar.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.pdmtaller2.a00073923_juanmelgar.Models.Dish

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<Dish>()

    fun addToCart(dish: Dish) {
        cartItems.add(dish)
    }

    fun clearCart() {
        cartItems.clear()
    }
}
