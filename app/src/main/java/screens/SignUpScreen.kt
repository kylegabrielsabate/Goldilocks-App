package com.example.goldilocks.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
fun SignUpScreen(
    authViewModel: AuthViewModel,
    onSignUpSuccess: () -> Unit,
    onNavigateToLogin: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.goldilocks_logo),
            contentDescription = "Goldilocks Logo",
            modifier = Modifier.width(180.dp).height(180.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Create Account", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = TextDark)
        Text("Join us to order your favorite treats", fontSize = 16.sp, color = TextGray, modifier = Modifier.padding(top = 8.dp, bottom = 32.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email Address") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password (Min. 6 characters)") },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            singleLine = true
        )

        if (errorMessage.isNotEmpty()) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(errorMessage, color = MaterialTheme.colorScheme.error, fontSize = 14.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                val error = authViewModel.signUp(email, password)
                if (error == null) {
                    onSignUpSuccess()
                } else {
                    errorMessage = error
                }
            },
            modifier = Modifier.fillMaxWidth().height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = GoldilocksYellow)
        ) {
            Text("Sign Up", color = TextDark, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(onClick = onNavigateToLogin) {
            Text("Already have an account? Sign In", color = TextGray)
        }
    }
}