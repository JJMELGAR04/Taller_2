package com.pdmtaller2.a00073923_juanmelgar.data

import com.pdmtaller2.a00073923_juanmelgar.Models.Dish
import com.pdmtaller2.a00073923_juanmelgar.Models.Restaurant
import com.pdmtaller2.a00073923_juanmelgar.R

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageResId = R.drawable.pizza_img,
        categories = listOf("Comida Italiana", "Pizzas"),
        menu = listOf(
            Dish(1, "Pizza Pepperoni", "Clásica pizza con pepperoni y queso.", R.drawable.pizza_img),
            Dish(2, "Pizza Vegetariana", "Pizza con variedad de vegetales frescos.", R.drawable.pizza_img)
        )
    ),
    Restaurant(
        id = 2,
        name = "Tacos El Salvador",
        description = "Tacos con sabor casero",
        imageResId = R.drawable.tacos_img,
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(3, "Taco al Pastor", "Taco de cerdo con piña y cebolla.", R.drawable.tacos_img),
            Dish(4, "Taco Vegano", "Taco relleno de vegetales y frijoles.", R.drawable.tacos_img)
        )
    ),
    Restaurant(
        id = 3,
        name = "Sushi Express",
        description = "Sushi rápido y fresco",
        imageResId = R.drawable.sushi_img,
        categories = listOf("Comida Asiática"),
        menu = listOf(
            Dish(5, "Sushi Salmón", "Rolls con salmón fresco y aguacate.", R.drawable.sushi_img),
            Dish(6, "Sushi Veggie", "Rolls con pepino, zanahoria y palta.", R.drawable.sushi_img)
        )
    ),
    Restaurant(
        id = 4,
        name = "Green Bowl",
        description = "Comida saludable para todos",
        imageResId = R.drawable.salad_img,
        categories = listOf("Comida Saludable", "Vegetariano"),
        menu = listOf(
            Dish(7, "Ensalada César", "Lechuga, pollo a la plancha y aderezo.", R.drawable.salad_img),
            Dish(8, "Bowl Vegano", "Quinoa, vegetales asados y hummus.", R.drawable.salad_img)
        )
    )
)