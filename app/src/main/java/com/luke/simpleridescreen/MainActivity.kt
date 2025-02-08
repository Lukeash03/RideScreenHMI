package com.luke.simpleridescreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
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
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RideScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RideScreen(modifier: Modifier = Modifier) {
    // State variables
    var motorOn by remember { mutableStateOf(true) }
    var speed by remember { mutableFloatStateOf(0f) }
    var tripA by remember { mutableFloatStateOf(0.0f) }
    val rideModes = listOf("Eco", "Normal", "SONIC")
    var selectedRideMode by remember { mutableStateOf(1) }
    var odometer by remember { mutableIntStateOf(2356) }
    var isAnimating by remember { mutableStateOf(true) }

    val animatedSpeed = remember { Animatable(0f) }

    // Animated background color transition
    val backgroundColor by animateColorAsState(
        targetValue = when {
            animatedSpeed.value >= 80f -> Color(0xFFe51c1b) // Red (High Speed)
            animatedSpeed.value >= 60f -> Color(0xFF8b652b) // Brown (Medium Speed)
            else -> Color(0xFF929a26) // Greenish-Yellow (Low Speed)
        },
        animationSpec = tween(1000),
    )

    // 🚀 Speed Animation Loop
    LaunchedEffect(key1 = isAnimating) {
        if (isAnimating) {
            delay(500)
            animatedSpeed.animateTo(
                targetValue = 100f,
                animationSpec = tween(durationMillis = 3000, easing = LinearEasing)
            )
            animatedSpeed.animateTo(
                targetValue = 0f,
                animationSpec = tween(durationMillis = 3000, easing = LinearEasing)
            )
            isAnimating = false
        }
    }

    // 🎨 Animate Gradient Radius (Small -> Large)
    val gradientRadius by animateFloatAsState(
        visibilityThreshold = 100f,
        targetValue = (animatedSpeed.value / 100f) * 800f + 600f, // Min 200f, Max 1000f
        animationSpec = tween(100)
    )

    val tintColor by animateColorAsState(
        targetValue = when {
            animatedSpeed.value >= 80f -> Color(0xFFe51c1b) // Red (High Speed)
            animatedSpeed.value >= 60f -> Color(0xFF8b652b) // Brown (Medium Speed)
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
        SpeedometerFrame1(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame2(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame3(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame4(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame5(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame6(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame7(animatedSpeed.value, tintColor = tintColor)
        SpeedometerFrame8(animatedSpeed.value, tintColor = tintColor)

        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Motor Status (Top Center)
            Text(
                text = if (motorOn) "Motor ON" else "Motor OFF",
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
                        text = "${animatedSpeed.value.toInt()}",
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
                    text = "Trip A\n$tripA",
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
                            if (selectedRideMode > 0) {
                                selectedRideMode--
                            }
                        },
                        enabled = selectedRideMode > 0
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowLeft,
                            contentDescription = "Left Arrow",
                            tint = if (selectedRideMode > 0) Color.White else Color.Gray,
                            modifier = Modifier.size(45.dp),
                        )
                    }

                    Box(
                        modifier = Modifier.width(300.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        AnimatedContent(
                            targetState = rideModes[selectedRideMode],
                            transitionSpec = {
                                (slideInHorizontally { it } + fadeIn()).togetherWith(
                                    slideOutHorizontally { -it } + fadeOut())
                            }
                        ) { mode ->
                            Row {
                                Text(
                                    text = if (selectedRideMode == 2) "E R D " else "",
                                    fontSize = 36.sp,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = Color.Gray
                                )
                                Text(
                                    text = mode,
                                    fontSize = 36.sp,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = if (selectedRideMode == 2) Color.Red else Color.Gray
                                )
                            }
                        }
                    }
                    IconButton(
                        onClick = {
                            if (selectedRideMode < rideModes.size - 1) {
                                selectedRideMode++
                            }
                        },
                        enabled = selectedRideMode < rideModes.size - 1
                    ) {
                        Icon(
                            Icons.Default.KeyboardArrowRight,
                            contentDescription = "Right Arrow",
                            tint = if (selectedRideMode > 0) Color.White else Color.Gray,
                            modifier = Modifier.size(45.dp)
                        )
                    }
                }

                // Odometer (Bottom Right)
                Text(
                    text = "ODO\n$odometer",
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 1024, heightDp = 768)
@Composable
fun RideScreenPreview() {
    SimpleRideScreenTheme {
        RideScreen()
    }
}
