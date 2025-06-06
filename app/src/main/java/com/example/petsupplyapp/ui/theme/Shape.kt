// app/src/main/java/com/example/petsupplyapp/ui/theme/Shape.kt
package com.example.petsupplyapp.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(4.dp),
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(12.dp), // Common for cards and buttons
    large = RoundedCornerShape(16.dp), // For larger containers
    extraLarge = RoundedCornerShape(24.dp)
)
