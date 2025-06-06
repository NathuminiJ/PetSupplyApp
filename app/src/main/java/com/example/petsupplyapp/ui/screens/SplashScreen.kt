// app/src/main/java/com/example/petsupplyapp/ui/screens/SplashScreen.kt
package com.example.petsupplyapp.ui.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource // For loading actual image assets
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.petsupplyapp.R // Make sure to import R for resources
import com.example.petsupplyapp.navigation.AppRoutes
import com.example.petsupplyapp.ui.theme.PetSupplyAppTheme // Import your custom theme

@Composable
fun SplashScreen(navController: NavController) {
    // State to control the fade-in animation
    var startAnimation by remember { mutableStateOf(false) }
    // Animate the alpha (transparency) of the content
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1500 // Animation duration
        ), label = "splash_fade_in_animation"
    ).value

    // LaunchedEffect to trigger the animation and navigate after a delay
    LaunchedEffect(key1 = true) {
        startAnimation = true // Start the fade-in animation
        kotlinx.coroutines.delay(2000) // Delay for animation to complete
        kotlinx.coroutines.delay(1000) // Additional delay before navigating (total 3 seconds)
        // Navigate to the OnBoardingScreen, preventing going back to splash
        navController.popBackStack()
        navController.navigate(AppRoutes.onboardingScreen)
    }

    // Determine background and text colors based on current theme mode
    val backgroundColor = if (isSystemInDarkTheme()) MaterialTheme.colorScheme.background else Color(0xFFF7C566) // Use your primary color for splash background
    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .alpha(alphaAnim), // Apply fade-in animation to the whole column
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pet Supply Store Logo
        // IMPORTANT: Replace `Icons.Filled.Pets` with your actual logo.
        // You'll need to add your logo image to `app/src/main/res/drawable/`
        // and reference it using `painterResource(id = R.drawable.your_logo_name)`.
        // For now, we use a placeholder icon.
        Icon(
            imageVector = Icons.Filled.Pets, // Placeholder icon
            contentDescription = "Pet Supply App Logo",
            modifier = Modifier.size(150.dp),
            tint = textColor // Tint the icon with text color for theme consistency
        )

        // Spacing between logo and text
        Text(
            text = "PetSupplyApp", // Your app name
            style = MaterialTheme.typography.headlineLarge.copy( // Using Material3 typography
                color = textColor,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                fontFamily = FontFamily.SansSerif // You can define custom fonts in Type.kt
            ),
            modifier = Modifier.padding(top = 24.dp)
        )

        // App Slogan/Tagline
        Text(
            text = "Your Best Friend Deserves the Best!", // A suitable slogan
            style = MaterialTheme.typography.bodyLarge.copy( // Using Material3 typography
                color = textColor.copy(alpha = 0.8f), // Slightly less prominent
                fontSize = 18.sp,
                fontFamily = FontFamily.SansSerif // You can define custom fonts
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 48.dp, vertical = 12.dp)
        )

        // Optional: A simple loading indicator
        CircularProgressIndicator(
            modifier = Modifier.padding(top = 48.dp),
            color = textColor // Indicator color matches text for consistency
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    // Create a dummy NavController for preview purposes
    val navController = rememberNavController()
    PetSupplyAppTheme { // Use your app's theme for the preview
        SplashScreen(navController = navController)
    }
}
