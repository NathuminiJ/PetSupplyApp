// app/src/main/java/com/example/petsupplyapp/ui/theme/Theme.kt
package com.example.petsupplyapp.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// Define your Light Color Scheme
private val LightColorScheme = lightColorScheme(
    primary = PrimaryColorLight,
    onPrimary = OnPrimaryLight,
    secondary = SecondaryColorLight,
    onSecondary = OnSecondaryLight,
    background = BackgroundLight,
    onBackground = OnBackgroundLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,
    // Add other colors like error, onError, primaryContainer, etc. as needed
)

// Define your Dark Color Scheme
private val DarkColorScheme = darkColorScheme(
    primary = PrimaryColorDark,
    onPrimary = OnPrimaryDark,
    secondary = SecondaryColorDark,
    onSecondary = OnSecondaryDark,
    background = BackgroundDark,
    onBackground = OnBackgroundDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,
    // Add other colors for dark mode
)

@Composable
fun PetSupplyAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Automatically detects system theme
    content: @Composable () -> Unit
) {
    // Choose the color scheme based on the darkTheme parameter
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        // Apply system bar colors to match the theme
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb() // Status bar color
            window.navigationBarColor = colorScheme.background.toArgb() // Navigation bar color
            // Set light/dark icons for status and navigation bars based on theme
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = darkTheme
        }
    }

    // Apply MaterialTheme with your custom color scheme, typography, and shapes
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography, // From Type.kt
        shapes = Shapes, // From Shape.kt
        content = content
    )
}
