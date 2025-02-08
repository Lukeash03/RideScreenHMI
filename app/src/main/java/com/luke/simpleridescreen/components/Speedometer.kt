package com.luke.simpleridescreen.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.luke.simpleridescreen.R

fun mapSpeedToScale(speed: Float, maxScale: Float): Float {
    return when {
        speed < 40f -> 1f - (speed / 40f) * (1f - maxScale)  // Shrinking starts slow
        speed in 40f..80f -> maxScale - ((speed - 40f) / 40f) * (maxScale - (maxScale - 0.06f))
        speed in 80f..100f -> (maxScale - 0.06f) - ((speed - 80f) / 20f) * 0.02f
        else -> mapSpeedToScale(200 - speed, maxScale) // Reverse effect after 100
    }
}

@Composable
fun SpeedometerFrame1(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 0.90f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 0.90f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector1_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(250.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-170).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector1_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(250.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (170).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )

}

@Composable
fun SpeedometerFrame2(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 0.94f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 0.94f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector2_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(290.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-186).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector2_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(290.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (186).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )


}

@Composable
fun SpeedometerFrame3(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 0.98f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 0.98f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector3_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(330.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-202).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector3_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(330.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (202).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}

@Composable
fun SpeedometerFrame4(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 1.02f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.02f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector4_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(370.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-217).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector4_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(370.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (217).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}

@Composable
fun SpeedometerFrame5(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 1.06f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.06f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector5_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(410.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-233).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector5_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(410.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (233).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )

}

@Composable
fun SpeedometerFrame6(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 1.1f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.1f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector6_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(450.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-249).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector6_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(450.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (249).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}

@Composable
fun SpeedometerFrame7(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 1.14f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.14f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector7_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(490.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-264).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector7_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(490.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (264).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}

@Composable
fun SpeedometerFrame8(animatedSpeed: Float, modifier: Modifier = Modifier, tintColor: Color) {

    val scale = mapSpeedToScale(animatedSpeed, 1.18f)
//    val scale by animateFloatAsState(mapSpeedToScale(animatedSpeed, 1.18f), animationSpec = tween(100, easing = FastOutSlowInEasing))

    Image(
        painter = painterResource(id = R.drawable.vector8_l), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(530.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (-280).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
    Image(
        painter = painterResource(id = R.drawable.vector8_r), // Load the SVG frame
        contentDescription = "Speedometer",
        modifier = modifier
            .size(530.dp)
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale
            )
            .offset(x = (280).dp, y = (-40).dp),
        colorFilter = ColorFilter.tint(tintColor)
    )
}
