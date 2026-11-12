package com.example.goldilocks.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.goldilocks.data.User

class AuthViewModel : ViewModel() {
    val currentUser = mutableStateOf<User?>(null)
    val isLoggedIn get() = currentUser.value != null

    // Simple in-memory user database for demo purposes
    private val registeredUsers = mutableStateListOf<User>()

    fun signUp(email: String, password: String): String? {
        if (email.isEmpty() || !email.contains("@")) {
            return "Please enter a valid email address."
        }
        if (password.length < 6) {
            return "Password must be at least 6 characters."
        }
        if (registeredUsers.any { it.email == email }) {
            return "Email is already registered."
        }

        val newUser = User(email, email.split("@").first())
        registeredUsers.add(newUser)
        currentUser.value = newUser
        return null // Success
    }

    fun login(email: String, password: String): String? {
        val user = registeredUsers.find { it.email == email }
        if (user != null) {
            currentUser.value = user
            return null // Success
        }
        return "Invalid email or password. Please sign up first."
    }

    fun logout() {
        currentUser.value = null
    }
}