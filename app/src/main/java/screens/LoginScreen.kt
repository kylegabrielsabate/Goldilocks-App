package com.example.goldilocks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.goldilocks.R
import com.example.goldilocks.ui.theme.GoldilocksYellow
import com.example.goldilocks.ui.theme.TextDark
import com.example.goldilocks.ui.theme.TextGray
import com.example.goldilocks.viewmodel.AuthViewModel

@Composable
fun LoginScreen(authViewModel: AuthViewModel, onLoginSuccess: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(32.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(painter = painterResource(id = R.drawable.goldilocks_logo), contentDescription = "Goldilocks Logo", modifier = Modifier.width(220.dp).height(220.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Text(text = "Welcome Back", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Text(text = "Sign in to order your favorite treats", fontSize = 16.sp, color = TextGray, modifier = Modifier.padding(top = 8.dp, bottom = 32.dp))

        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email Address") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), singleLine = true)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = password, onValueChange = { password = it }, label = { Text("Password") }, modifier = Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp), singleLine = true)
        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = { if (email.isNotEmpty() && password.isNotEmpty()) { authViewModel.login(email, password); onLoginSuccess() } }, modifier = Modifier.fillMaxWidth().height(56.dp), shape = RoundedCornerShape(12.dp), colors = ButtonDefaults.buttonColors(containerColor = GoldilocksYellow)) {
            Text("Sign In", color = TextDark, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}