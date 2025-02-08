package com.luke.simpleridescreen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.luke.simpleridescreen.components.SpeedometerFrame1
import com.luke.simpleridescreen.components.SpeedometerFrame2
import com.luke.simpleridescreen.components.SpeedometerFrame3
import com.luke.simpleridescreen.components.SpeedometerFrame4
import com.luke.simpleridescreen.components.SpeedometerFrame5
import com.luke.simpleridescreen.components.SpeedometerFrame6
import com.luke.simpleridescreen.components.SpeedometerFrame7
import com.luke.simpleridescreen.components.SpeedometerFrame8
import com.luke.simpleridescreen.ui.theme.SimpleRideScreenTheme
import com.luke.simpleridescreen.ui.theme.highSwiftFamily
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleRideScreenTheme {

                val state = remember { mutableStateOf(RideScreenState()) }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RideScreen(
                        state = state.value,
                        onEvent = { event ->
                            when (event) {
                                is RideScreenEvent.ToggleMotor -> {
                                    state.value = state.value.copy(motorOn = !state.value.motorOn)
                                    if (state.value.motorOn) state.value =
                                        state.value.copy(isAnimating = true)
                                }

                                is RideScreenEvent.ChangeRideMode -> {
                                    state.value = state.value.copy(selectedRideMode = event.index)
                                }

                                is RideScreenEvent.StartAnimation -> {
                                    state.value = state.value.copy(isAnimating = event.isAnimating)
                                }
                            }
                        },
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }
    }
}

@Composable
fun RideScreen(
    state: RideScreenState,
    onEvent: (RideScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    val rideModes = listOf("Eco", "Normal", "SONIC")

    // Animated background color transition
    val backgroundColor by animateColorAsState(
        targetValue = when {
            state.animatedSpeed.value >= 80f -> Color(0xFFe51c1b) // Red (High Speed)
            state.animatedSpeed.value >= 60f -> Color(0xFF8b652b) // Brown (Medium Speed)
            else -> Color(0xFF929a26) // Greenish-Yellow (Low Speed)
        },
        animationSpec = tween(1000),
    )

    // 🚀 Speed Animation Loop
    LaunchedEffect(key1 = state.isAnimating) {
        if (state.isAnimating) {
            delay(500)
            state.animatedSpeed.animateTo(
                targetValue = 100f,
                animationSpec = tween(3000, easing = LinearEasing)
            )
            state.animatedSpeed.animateTo(
                targetValue = 0f,
                animationSpec = tween(3000, easing = LinearEasing)
            )
            onEvent(RideScreenEvent.StartAnimation(false))
        }
    }

    // 🎨 Animate Gradient Radius (Small -> Large)
    val gradientRadius by animateFloatAsState(
        visibilityThreshold = 0.1f,
        targetValue = (state.animatedSpeed.value / 100f) * 800f + 600f, // Min 200f, Max 1000f
        animationSpec = tween(100)
    )

    val tintColor by animateColorAsState(
        targetValue = when {
            state.animatedSpeed.value >= 80f -> Color(0xFFe51c1b) // Red (High Speed)
            state.animatedSpeed.value >= 60f -> Color(0xFF8b652b) // Brown (Medium Speed)
            else -> Color(0xFF929a26) // Greenish-Yellow (Low Speed)
        },
        animationSpec = tween(1000),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.radialGradient(
                    colors = listOf(backgroundColor, Color.Black),
                    center = Offset.Unspecified,
                    radius = gradientRadius
                )
            ),
        contentAlignment = Alignment.Center
    ) {


        // 🔹 Background Path Animation (Based on Speed)
        SpeedometerFrame1(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame2(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame3(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame4(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame5(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame6(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame7(state.animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame8(state.animatedSpeed.value, tintColor = tintColor)

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Motor Status (Top Center)
            Text(
                modifier = Modifier.clickable { onEvent(RideScreenEvent.ToggleMotor) },
                text = if (state.motorOn) "Motor ON" else "Motor OFF",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            // Speed (Center)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.weight(1f)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
                Row {
                    Text(
                        text = "${state.animatedSpeed.value.toInt()}",
                        style = MaterialTheme.typography.displayLarge,
                        fontFamily = highSwiftFamily,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 140.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.width(36.dp))
                }
                Text(
                    text = "Km/h",
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 36.sp,
                    color = Color.White
                )
            }

            // Bottom Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Absolute.SpaceAround,
                verticalAlignment = Alignment.Bottom
            ) {
                // Trip A (Bottom Left)
                Text(
                    text = "Trip A\n${state.tripA}",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )

                // Ride Mode (Bottom Center)
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = {
                            if (state.selectedRideMode > 0) {
                                onEvent(RideScreenEvent.ChangeRideMode(state.selectedRideMode - 1))
                            }
                        },
                        enabled = state.selectedRideMode > 0
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Left Arrow",
                            tint = if (state.selectedRideMode > 0) Color.White else Color.Gray,
                            modifier = Modifier.size(45.dp),
                        )
                    }

                    Box(
                        modifier = Modifier.width(300.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedContent(
                            targetState = rideModes[state.selectedRideMode],
                            transitionSpec = {
                                (slideInHorizontally { it } + fadeIn()).togetherWith(
                                    slideOutHorizontally { -it } + fadeOut())
                            }
                        ) { mode ->
                            Row {
                                AnimatedVisibility(
                                    visible = state.selectedRideMode == 2,
                                    enter = slideInHorizontally { it } + fadeIn(),
                                    exit = slideOutHorizontally { -it } + fadeOut()
                                ) {
                                    Text(
                                        text = "E R D ",
                                        fontSize = 36.sp,
                                        textAlign = TextAlign.Center,
                                        style = MaterialTheme.typography.bodyLarge,
                                        color = Color.Gray
                                    )
                                }
                                Text(
                                    text = mode,
                                    fontSize = 36.sp,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (state.selectedRideMode == 2) Color.Red else Color.Gray
                                )
                            }
                        }
                    }
                    IconButton(
                        onClick = {
                            if (state.selectedRideMode < rideModes.size - 1) {
                                onEvent(RideScreenEvent.ChangeRideMode(state.selectedRideMode + 1))
                            }
                        },
                        enabled = state.selectedRideMode < rideModes.size - 1
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = "Right Arrow",
                            tint = if (state.selectedRideMode < rideModes.size - 1) Color.White else Color.Gray,
                            modifier = Modifier.size(45.dp)
                        )
                    }
                }

                // Odometer (Bottom Right)
                Text(
                    text = "ODO\n${state.odometer}",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
        }
    }
}

@SuppressLint("UnrememberedAnimatable")
@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun RideScreenPreview() {
    SimpleRideScreenTheme {
        RideScreen(
            state = RideScreenState(
                motorOn = true,
                tripA = 0.0f,
                selectedRideMode = 1,
                odometer = 2356,
                isAnimating = true,
                animatedSpeed = Animatable(0f)
            ),
            onEvent = { },
            modifier = Modifier,
        )
    }
}
