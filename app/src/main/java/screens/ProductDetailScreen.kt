package com.example.goldilocks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goldilocks.data.Product
import com.example.goldilocks.ui.theme.*
import com.example.goldilocks.viewmodel.CartViewModel

@Composable
fun ProductDetailScreen(product: Product, cartViewModel: CartViewModel, onBack: () -> Unit) {
    var dedication by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth().height(300.dp)) {
            Image(painter = painterResource(id = product.imageResId), contentDescription = product.name, modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)
            IconButton(onClick = onBack, modifier = Modifier.padding(16.dp).align(Alignment.TopStart)) {
                Surface(shape = RoundedCornerShape(50), color = PureWhite.copy(alpha = 0.8f)) { Text("←", modifier = Modifier.padding(8.dp), fontWeight = FontWeight.Bold) }
            }
        }

        Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {
            Text(text = product.name, fontSize = 26.sp, fontWeight = FontWeight.Bold, color = TextDark)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "₱${"%.2f".format(product.price)}", fontSize = 24.sp, color = GoldilocksYellowDark, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            Surface(color = GoldilocksYellow.copy(alpha = 0.2f), shape = RoundedCornerShape(8.dp)) {
                Text(text = product.category, modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp), color = TextDark, fontWeight = FontWeight.Medium)
            }

            // DEDICATION ONLY FOR WHOLE CAKES
            if (product.isCake) {
                Spacer(modifier = Modifier.height(24.dp))
                Text("Add a special message:", fontWeight = FontWeight.SemiBold, color = TextDark)
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = dedication, onValueChange = { dedication = it }, placeholder = { Text("e.g., Happy Birthday, Maria! Love, Juan") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), maxLines = 3)
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = { cartViewModel.addToCart(product, dedication); onBack() }, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = GoldilocksYellow)) {
                Text("Add to Cart", color = TextDark, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            }
        }
    }
}