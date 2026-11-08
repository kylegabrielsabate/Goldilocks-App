package com.example.goldilocks.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.goldilocks.data.User

class AuthViewModel : ViewModel() {
    val currentUser = mutableStateOf<User?>(null)
    val isLoggedIn get() = currentUser.value != null

    fun login(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            currentUser.value = User(email, email.split("@").first())
        }
    }

    fun logout() {
        currentUser.value = null
    }
}