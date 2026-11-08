package com.example.goldilocks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goldilocks.R
import com.example.goldilocks.data.ProductRepository
import com.example.goldilocks.ui.theme.*
import com.example.goldilocks.viewmodel.AuthViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(authViewModel: AuthViewModel, onProductClick: (Int) -> Unit, onLoginClick: () -> Unit, onLogout: () -> Unit, onCartClick: () -> Unit) {
    var selectedCategory by remember { mutableStateOf<String?>(null) }
    val categories = ProductRepository.getCategories()
    val isLoggedIn = authViewModel.isLoggedIn
    val products = if (selectedCategory == null) ProductRepository.allProducts else ProductRepository.allProducts.filter { it.category == selectedCategory }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Image(painter = painterResource(id = R.drawable.goldilocks_logo), contentDescription = "Logo", modifier = Modifier.height(80.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                IconButton(onClick = onCartClick) { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart", tint = TextDark) }
                TextButton(onClick = { if (isLoggedIn) onLogout() else onLoginClick() }) { Text(if (isLoggedIn) "Logout" else "Sign In", color = TextDark, fontWeight = FontWeight.Bold) }
            }
        }

        LazyRow(contentPadding = PaddingValues(horizontal = 20.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            item { FilterChip(selected = selectedCategory == null, onClick = { selectedCategory = null }, label = { Text("All") }, shape = RoundedCornerShape(20.dp), colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GoldilocksYellow, selectedLabelColor = TextDark)) }
            items(categories) { category -> FilterChip(selected = selectedCategory == category, onClick = { selectedCategory = category }, label = { Text(category) }, shape = RoundedCornerShape(20.dp), colors = FilterChipDefaults.filterChipColors(selectedContainerColor = GoldilocksYellow, selectedLabelColor = TextDark)) }
        }

        Spacer(modifier = Modifier.height(20.dp))

        LazyVerticalGrid(columns = GridCells.Adaptive(170.dp), contentPadding = PaddingValues(horizontal = 20.dp, vertical = 20.dp), horizontalArrangement = Arrangement.spacedBy(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(products) { product -> ProductCard(product = product, onClick = { onProductClick(product.id) }) }
        }
    }
}

@Composable
fun ProductCard(product: com.example.goldilocks.data.Product, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = PureWhite), elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)) {
        Column {
            Image(painter = painterResource(id = product.imageResId), contentDescription = product.name, modifier = Modifier.fillMaxWidth().height(130.dp).clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)), contentScale = ContentScale.Crop)
            Column(modifier = Modifier.padding(12.dp)) {
                Text(text = product.name, fontWeight = FontWeight.SemiBold, color = TextDark, maxLines = 2, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
                Text(text = "₱${"%.2f".format(product.price)}", color = GoldilocksYellowDark, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}