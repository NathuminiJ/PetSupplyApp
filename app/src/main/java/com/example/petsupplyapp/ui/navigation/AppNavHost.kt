// app/src/main/java/com/example/petsupplyapp/navigation/AppNavHost.kt
package com.example.petsupplyapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.petsupplyapp.ui.screens.SplashScreen
import com.example.petsupplyapp.ui.screens.OnBoardingScreen
import com.example.petsupplyapp.ui.screens.LoginScreen
import com.example.petsupplyapp.ui.screens.RegisterScreen
// Import other screens as you create them:
// import com.example.petsupplyapp.ui.screens.HomeScreen
// import com.example.petsupplyapp.ui.screens.CartScreen
// import com.example.petsupplyapp.ui.screens.ProductDetailsScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppRoutes.splashScreen, // The splash screen is the first
        modifier = modifier
    ) {
        composable(AppRoutes.splashScreen) {
            SplashScreen(navController = navController)
        }
        composable(AppRoutes.onboardingScreen) {
            // Placeholder for OnBoardingScreen
            OnBoardingScreen(navController = navController)
        }
        composable(AppRoutes.loginScreen) {
            // Placeholder for LoginScreen
            LoginScreen(navController = navController)
        }
        composable(AppRoutes.registerScreen) {
            // Placeholder for RegisterScreen
            RegisterScreen(navController = navController)
        }
        // Add more composable routes for your other screens:
        // composable(AppRoutes.homeScreen) { HomeScreen(navController = navController) }
        // composable(AppRoutes.cartScreen) { CartScreen(navController = navController) }
        // composable(AppRoutes.productDetailsScreen) { backStackEntry ->
        //     val productId = backStackEntry.arguments?.getString("productId")
        //     ProductDetailsScreen(navController = navController, productId = productId)
        // }
    }
}
