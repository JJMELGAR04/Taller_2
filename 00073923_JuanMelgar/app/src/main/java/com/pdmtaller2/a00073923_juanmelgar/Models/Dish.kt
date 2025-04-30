package com.pdmtaller2.a00073923_juanmelgar.Models

import kotlinx.serialization.Serializable

@Serializable
data class Dish(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int
)