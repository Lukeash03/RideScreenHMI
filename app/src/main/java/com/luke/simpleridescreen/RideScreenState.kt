package com.luke.simpleridescreen

import androidx.compose.animation.core.Animatable

data class RideScreenState(
    val motorOn: Boolean = true,
    val tripA: Float = 0.0f,
    val selectedRideMode: Int = 1,
    val odometer: Int = 2356,
    val isAnimating: Boolean = true,
    val animatedSpeed: Animatable<Float, *> = Animatable(0f)
)
