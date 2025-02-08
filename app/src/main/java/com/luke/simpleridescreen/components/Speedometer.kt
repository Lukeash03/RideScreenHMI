package com.luke.simpleridescreen.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luke.simpleridescreen.R
import kotlin.math.min

fun mapSpeedToScale(speed: Float, maxScale: Float): Float {
    return when {
        speed < 40f -> 1f - (speed / 40f) * (1f - maxScale)  // Shrinking starts slow
        speed in 40f..80f -> maxScale - ((speed - 40f) / 40f) * (maxScale - (maxScale - 0.06f))
        speed in 80f..100f -> (maxScale - 0.06f) - ((speed - 80f) / 20f) * 0.02f
        else -> mapSpeedToScale(200 - speed, maxScale) // Reverse effect after 100
    }
}

@Composable
fun SpeedometerFrame1(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 0.90f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 0.90f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector1_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(200.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-140).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector1_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(200.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (140).dp, y = (-40).dp)
    )

}

@Composable
fun SpeedometerFrame2(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 0.94f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 0.94f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector2_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(240.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-156).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector2_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(240.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (156).dp, y = (-40).dp)
    )


}

@Composable
fun SpeedometerFrame3(animatedSpeed: Float, modifier: Modifier = Modifier) {

    fun mapSpeedToShrinkScale(speed: Float): Float {
        return when {
            speed < 40f -> 1f - (speed / 40f) * 0.04f  // 1x → 0.96x
            speed in 40f..80f -> 0.96f - ((speed - 40f) / 40f) * 0.16f  // 0.96x → 0.80x
            else -> 0.80f - ((speed - 80f) / 19f) * 0.04f  // 0.80x → 0.76x
        }
    }

    val scale = mapSpeedToScale(animatedSpeed, 0.98f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 0.98f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector3_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(280.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-172).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector3_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(280.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (172).dp, y = (-40).dp)
    )
}

@Composable
fun SpeedometerFrame4(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 1.02f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.02f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector4_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(320.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-187).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector4_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(320.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (187).dp, y = (-40).dp)
    )
}

@Composable
fun SpeedometerFrame5(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 1.06f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.06f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector5_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(360.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-203).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector5_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(360.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (203).dp, y = (-40).dp)
    )

}

@Composable
fun SpeedometerFrame6(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 1.1f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.1f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector6_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(400.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-219).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector6_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(400.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (219).dp, y = (-40).dp)
    )
}

@Composable
fun SpeedometerFrame7(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 1.14f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.14f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector7_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(440.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-234).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector7_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(440.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (234).dp, y = (-40).dp)
    )
}

@Composable
fun SpeedometerFrame8(animatedSpeed: Float, modifier: Modifier = Modifier) {

    val scale = mapSpeedToScale(animatedSpeed, 1.18f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.18f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector8_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(480.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-250).dp, y = (-40).dp)
    )
    Image(
        painter = painterResource(id = R.drawable.vector8_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(480.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (250).dp, y = (-40).dp)
    )
}
