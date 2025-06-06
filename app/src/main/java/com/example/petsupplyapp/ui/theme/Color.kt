// app/src/main/java/com/example/petsupplyapp/ui/theme/Color.kt
package com.example.petsupplyapp.ui.theme

import androidx.compose.ui.graphics.Color

// Define your brand colors here based on your pet store design
// Light Theme Palette (referencing your design images, e.g., the coffee app's warm tones)
val PrimaryColorLight = Color(0xFFF7C566) // A warm, friendly yellow/orange (from your design)
val SecondaryColorLight = Color(0xFF8B4513) // A darker brown, like coffee (from your design)
val BackgroundLight = Color(0xFFFFFFFF) // White background for light mode
val SurfaceLight = Color(0xFFF5F5F5) // Lighter surface for cards, etc.
val OnPrimaryLight = Color.Black // Text/icons on primary color
val OnSecondaryLight = Color.White // Text/icons on secondary color
val OnBackgroundLight = Color.Black // Text/icons on background
val OnSurfaceLight = Color.Black // Text/icons on surface

// Dark Theme Palette (adjusting for dark mode readability and aesthetics)
val PrimaryColorDark = Color(0xFFF7C566) // Can be the same or slightly adjusted
val SecondaryColorDark = Color(0xFFD2B48C) // Lighter brown for dark mode accent
val BackgroundDark = Color(0xFF121212) // Very dark grey background
val SurfaceDark = Color(0xFF282828) // Darker surface for cards, etc.
val OnPrimaryDark = Color.Black // Text/icons on primary color
val OnSecondaryDark = Color.Black // Text/icons on secondary color (if secondary is light)
val OnBackgroundDark = Color.White // Text/icons on dark background
val OnSurfaceDark = Color.White // Text/icons on dark surface
