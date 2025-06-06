// app/src/main/java/com/example/petsupplyapp/ui/screens/OnBoardingScreen.kt
package com.example.petsupplyapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petsupplyapp.navigation.AppRoutes
import com.example.petsupplyapp.ui.theme.PetSupplyAppTheme

@Composable
fun OnBoardingScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to PetSupplyApp!")
        Button(onClick = { navController.navigate(AppRoutes.loginScreen) }) {
            Text("Go to Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingScreenPreview() {
    val navController = rememberNavController()
    PetSupplyAppTheme {
        OnBoardingScreen(navController = navController)
    }
}
