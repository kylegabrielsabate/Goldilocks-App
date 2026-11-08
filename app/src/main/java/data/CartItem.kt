package com.example.goldilocks.data

data class CartItem(
    val product: Product,
    val dedication: String = "",
    val quantity: Int = 1
)