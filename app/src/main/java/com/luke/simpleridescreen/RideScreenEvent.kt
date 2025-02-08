package com.luke.simpleridescreen

sealed class RideScreenEvent {
    data object ToggleMotor : RideScreenEvent()
    data class ChangeRideMode(val index: Int) : RideScreenEvent()
    data class StartAnimation(val isAnimating: Boolean) : RideScreenEvent()
}