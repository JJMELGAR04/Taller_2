package com.pdmtaller2.a00073923_juanmelgar.data

import com.pdmtaller2.a00073923_juanmelgar.Models.Dish
import com.pdmtaller2.a00073923_juanmelgar.Models.Restaurant
import com.pdmtaller2.a00073923_juanmelgar.R

val restaurants = listOf(
    Restaurant(
        id = 1,
        name = "Pizza Planet",
        description = "Las mejores pizzas del universo",
        imageResId = R.drawable.pizzalogo,
        categories = listOf("Pizzas"),
        menu = listOf(
            Dish(1, "Pizza Pepperoni", "Clásica pizza con pepperoni y queso.", R.drawable.pizza),
            Dish(2, "Pizza Vegetariana", "Pizza con variedad de vegetales frescos.", R.drawable.pizza)
        )
    ),
    Restaurant(
        id = 2,
        name = "Tacos El Salvador",
        description = "Tacos con sabor casero",
        imageResId = R.drawable.tacoslogo,
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(3, "Taco al Pastor", "Taco de cerdo con piña y cebolla.", R.drawable.tacos),
            Dish(4, "Taco Vegano", "Taco relleno de vegetales y frijoles.", R.drawable.tacos)
        )
    ),
    Restaurant(
        id = 3,
        name = "Sushi Express",
        description = "Sushi rápido y fresco",
        imageResId = R.drawable.sushi,
        categories = listOf("Comida Asiática"),
        menu = listOf(
            Dish(5, "Sushi Salmón", "Rolls con salmón fresco y aguacate.", R.drawable.sushi),
            Dish(6, "Sushi Veggie", "Rolls con pepino, zanahoria y palta.", R.drawable.sushi)
        )
    ),
    Restaurant(
        id = 4,
        name = "Tacos Hermanos",
        description = "Comida saludable para todos",
        imageResId = R.drawable.tacoslogo2,
        categories = listOf("Comida Mexicana"),
        menu = listOf(
            Dish(7, "Tacos de burra", "Taco de burra con cebolla y cilantro.", R.drawable.salad),
            Dish(8, "Taco de Tocino", "Taco de tocino con cebolla y cilantro.", R.drawable.salad)
        )
    ),
    Restaurant(
        id = 5,
        name = "Pizza Hut",
        description = "Comida saludable para todos",
        imageResId = R.drawable.pizzalogo1,
        categories = listOf("Pizzas"),
        menu = listOf(
            Dish(9, "Pizza al Pastor", "Contiene un ingrediente especial el pastor", R.drawable.pizza2),
            Dish(10, "Pizza de Pina", "Una pizza con ingrediente de pina", R.drawable.pizza2)
        )
    ),


)