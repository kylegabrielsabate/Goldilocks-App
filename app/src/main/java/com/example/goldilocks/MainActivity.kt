package com.example.goldilocks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.goldilocks.data.ProductRepository
import com.example.goldilocks.screens.*
import com.example.goldilocks.ui.theme.CreamBackground
import com.example.goldilocks.viewmodel.AuthViewModel
import com.example.goldilocks.viewmodel.CartViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = CreamBackground) {
                GoldilocksApp()
            }
        }
    }
}

@Composable
fun GoldilocksApp() {
    val navController = rememberNavController()
    val authViewModel: AuthViewModel = viewModel()
    val cartViewModel: CartViewModel = viewModel()

    val isLoggedIn by remember { derivedStateOf { authViewModel.isLoggedIn } }

    NavHost(navController = navController, startDestination = "home") {
        composable("login") {
            LoginScreen(authViewModel = authViewModel, onLoginSuccess = { navController.popBackStack() })
        }

        composable("home") {
            HomeScreen(
                authViewModel = authViewModel,
                onProductClick = { productId -> navController.navigate("product/$productId") },
                onLoginClick = { navController.navigate("login") },
                onLogout = { authViewModel.logout() },
                onCartClick = { if (isLoggedIn) navController.navigate("cart") else navController.navigate("login") }
            )
        }

        composable("product/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
            val product = ProductRepository.allProducts.find { it.id == productId }
            if (product != null) {
                ProductDetailScreen(product = product, cartViewModel = cartViewModel, onBack = { navController.popBackStack() })
            }
        }

        composable("cart") {
            CartScreen(cartViewModel = cartViewModel, onCheckout = { cartViewModel.clearCart(); navController.popBackStack() }, onBack = { navController.popBackStack() })
        }
    }
}