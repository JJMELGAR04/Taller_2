package com.pdmtaller2.a00073923_juanmelgar.Models


import kotlinx.serialization.Serializable

@Serializable
data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int,
    val categories: List<String>,
    val menu: List<Dish>
)