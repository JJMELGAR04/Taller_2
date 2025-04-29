package com.pdmtaller2.a00073923_juanmelgar.Models

import com.pdmtaller2.a00073923_juanmelgar.Models.Dish
import com.pdmtaller2.a00073923_juanmelgar.Models.Restaurant

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageUrl = "https://example.com/pizza.jpg",
        categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(1, "Pizza Pepperoni", "Clásica pizza con pepperoni y queso.", "https://example.com/pepperoni.jpg"),
            Dish(2, "Pizza Vegetariana", "Pizza saludable con verduras frescas.", "https://example.com/veggie.jpg")
        )
    ),
    Restaurant(
        id = 2,
        name = "Burger King Kong",
        description = "Las hamburguesas más monstruosas",
        imageUrl = "https://example.com/burger.jpg",
        categories = listOf("Pizzas", "Comida Italiana", "Vegetariano"),
        menu = listOf(
            Dish(3, "Hamburguesa Doble Queso", "Doble carne, doble queso, doble sabor.", "https://example.com/doublecheese.jpg"),
            Dish(4, "Hamburguesa Vegana", "Una opción deliciosa y saludable.", "https://example.com/veganburger.jpg")
        )
    )
)