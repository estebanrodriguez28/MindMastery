package com.example.firstapp.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val lighterGreen = Color(0xFF228B22)
val darkGreen = Color(0xFF006400)

val gradient = Brush.verticalGradient(
    0.0f to darkGreen,
    500.0f to lighterGreen,
    startY = 0.0f,
    endY = 1500.0f
)