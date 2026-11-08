package com.example.goldilocks.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goldilocks.ui.theme.*
import com.example.goldilocks.viewmodel.CartViewModel

@Composable
fun CartScreen(cartViewModel: CartViewModel, onCheckout: () -> Unit, onBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onBack) { Text("←", fontSize = 20.sp) }
            Text("Your Cart", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = TextDark)
        }
        Spacer(modifier = Modifier.height(24.dp))

        if (cartViewModel.cartItems.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize().weight(1f), contentAlignment = Alignment.Center) { Text("Your cart is empty.", color = TextGray) }
        } else {
            LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp), modifier = Modifier.weight(1f)) {
                items(cartViewModel.cartItems) { item ->
                    Card(shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = PureWhite), elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text(item.product.name, fontWeight = FontWeight.SemiBold, color = TextDark)
                                Text("₱${"%.2f".format(item.product.price * item.quantity)}", fontWeight = FontWeight.Bold, color = GoldilocksYellowDark)
                            }
                            if (item.dedication.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(text = "🎁 Dedication: \"${item.dedication}\"", style = MaterialTheme.typography.bodySmall, color = TextGray, fontStyle = androidx.compose.ui.text.font.FontStyle.Italic)
                            }
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("Quantity: ${item.quantity}", color = TextGray)
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Divider()
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Total Amount:", fontSize = 18.sp, fontWeight = FontWeight.Medium, color = TextDark)
                Text("₱${"%.2f".format(cartViewModel.getTotalPrice())}", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = GoldilocksYellowDark)
            }
            Spacer(modifier = Modifier.height(24.dp))
            Button(onClick = onCheckout, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = GoldilocksYellow)) {
                Text("Proceed to Checkout", color = TextDark, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}