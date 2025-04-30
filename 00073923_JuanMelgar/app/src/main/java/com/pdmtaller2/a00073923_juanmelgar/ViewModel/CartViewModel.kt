package com.pdmtaller2.a00073923_juanmelgar.ViewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.pdmtaller2.a00073923_juanmelgar.Models.Dish

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<Dish>()

    fun addDish(dish: Dish) {
        cartItems.add(dish)
    }
    fun removeDish(dish: Dish) {
        cartItems.remove(dish)
    }

    fun clearCart() {
        cartItems.clear()
    }

}
