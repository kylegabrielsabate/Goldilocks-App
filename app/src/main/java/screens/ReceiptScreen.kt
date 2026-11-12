package com.example.goldilocks.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goldilocks.ui.theme.*
import com.example.goldilocks.viewmodel.CartViewModel

@Composable
fun ReceiptScreen(
    cartViewModel: CartViewModel,
    onBackToHome: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Order Confirmed!", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Thank you for choosing Goldilocks", fontSize = 16.sp, color = TextGray, textAlign = TextAlign.Center)

        Spacer(modifier = Modifier.height(32.dp))

        // Elegant Receipt Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = PureWhite),
            border = BorderStroke(1.dp, GoldilocksYellow.copy(alpha = 0.3f))
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Order Summary", fontWeight = FontWeight.Bold, fontSize = 18.sp, color = TextDark)
                    Text("Receipt #${(1000..9999).random()}", color = TextGray, fontSize = 14.sp)
                }
                Divider(modifier = Modifier.padding(vertical = 12.dp), color = GoldilocksYellow.copy(alpha = 0.3f))

                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.weight(1f, fill = false)
                ) {
                    items(cartViewModel.lastOrderItems) { item ->
                        Column {
                            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                                Text("${item.quantity}x ${item.product.name}", fontWeight = FontWeight.Medium, color = TextDark)
                                Text("₱${"%.2f".format(item.product.price * item.quantity)}", fontWeight = FontWeight.SemiBold, color = TextDark)
                            }
                            if (item.dedication.isNotEmpty()) {
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(
                                    text = "🎁 \"${item.dedication}\"",
                                    fontSize = 13.sp,
                                    color = TextGray,
                                    fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
                                )
                            }
                        }
                    }
                }

                Divider(modifier = Modifier.padding(vertical = 16.dp), color = GoldilocksYellow.copy(alpha = 0.3f))

                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Total Amount", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = TextDark)
                    Text(
                        "₱${"%.2f".format(cartViewModel.lastOrderTotal.value)}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = GoldilocksYellowDark
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onBackToHome,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GoldilocksYellow)
        ) {
            Text("Back to Home", color = TextDark, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}