package com.example.goldilocks.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.goldilocks.data.CartItem
import com.example.goldilocks.data.Product

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<CartItem>()

    fun addToCart(product: Product, dedication: String = "") {
        val existingItem = cartItems.find { it.product.id == product.id && it.dedication == dedication }
        if (existingItem != null) {
            val index = cartItems.indexOf(existingItem)
            cartItems[index] = existingItem.copy(quantity = existingItem.quantity + 1)
        } else {
            cartItems.add(CartItem(product, dedication, 1))
        }
    }

    fun removeFromCart(item: CartItem) {
        cartItems.remove(item)
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.product.price * it.quantity }
    }

    fun clearCart() {
        cartItems.clear()
    }
}