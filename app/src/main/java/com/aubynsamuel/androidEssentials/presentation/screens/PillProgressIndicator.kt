package com.aubynsamuel.androidEssentials.presentation.screens

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathMeasure
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.drawText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aubynsamuel.androidEssentials.presentation.theme.background
import com.aubynsamuel.androidEssentials.presentation.theme.cardBackground
import com.aubynsamuel.androidEssentials.presentation.theme.plusJakartaSansFontFamily
import com.aubynsamuel.androidEssentials.presentation.theme.strokeColor
import kotlin.math.roundToInt

@Composable
fun PillProgressIndicatorScreen() {
    var progress by remember { mutableIntStateOf(50) }
    var progressValues by remember { mutableStateOf(listOf(20, 50)) }
    var decreaseValues by remember { mutableStateOf(listOf(20, 50)) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            StatusCard(
                progress = progress
            )

            Row {
                progressValues.forEach {
                    Button(
                        onClick = {
                            progress = if (progress + it <= 100) progress + it
                            else 100
                        },
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        Text("Increase by $it%")
                    }
                }
            }
            Row {
                decreaseValues.forEach {
                    Button(
                        onClick = {
                            progress = if (progress - it >= 0) progress - it
                            else 0
                        },
                        modifier = Modifier
                            .padding(top = 30.dp)
                            .padding(horizontal = 10.dp)
                    ) {
                        Text("Decrease by $it%")
                    }
                }
            }
        }
    }
}

@Composable
fun StatusCard(
    modifier: Modifier = Modifier,
    progress: Int = 0,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "You are doing\n Well",
                fontFamily = plusJakartaSansFontFamily,
                fontSize = 20.sp
            )
            PillProgressIndicator(
                progress = progress
            )
        }
    }
}

@Composable
fun PillProgressIndicator(
    modifier: Modifier = Modifier,
    progress: Int = 0,
    canvasSize: DpSize = DpSize(80.dp, 40.dp),
) {

    val safeProgress = progress.coerceIn(0, 100)
    val animatedProgress = remember { Animatable(0f) }
    val textMeasurer = rememberTextMeasurer()
    LaunchedEffect(safeProgress) {
        animatedProgress
            .animateTo(
                targetValue = safeProgress.toFloat(),
                animationSpec = tween(
                    durationMillis = 2_000,
                    easing = FastOutSlowInEasing
                )
            )
    }

    Canvas(
        modifier = modifier
            .size(canvasSize)
    ) {

        val strokeWidth = size.maxDimension * 0.08f
        val innerCircleRadius = size.maxDimension * 0.08f
        val outerCircleRadius = size.maxDimension * 0.05f


        val textLayoutResult = textMeasurer
            .measure(
                text = "${animatedProgress.value.roundToInt()}%",
                style = TextStyle(
                    fontFamily = plusJakartaSansFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = if (progress >= 45) Color.Green else Color.Red
                )
            )


        val roundRect = RoundRect(
            rect = Rect(
                left = 0f,
                top = 0f,
                right = size.width,
                bottom = size.height
            ),
            cornerRadius = CornerRadius(size.height / 2)
        )

        val path = Path().apply {
            addRoundRect(
                roundRect = roundRect,
                direction = Path.Direction.Clockwise
            )
        }

        val progressPath = Path()

        val pathMeasure = PathMeasure().apply { setPath(path, true) }
        val pathLength = pathMeasure.length
        val pathEnd = pathLength * animatedProgress.value.div(100)


        pathMeasure.getSegment(
            startDistance = 0f,
            stopDistance = pathEnd,
            destination = progressPath,
            startWithMoveTo = true
        )
        val circleHeadOffset = pathMeasure.getPosition(pathEnd)

        drawRoundRect(
            color = background,
            size = Size(roundRect.width, roundRect.height),
            cornerRadius = CornerRadius(roundRect.height / 2),
            style = Stroke(width = strokeWidth)
        )
        drawPath(
            path = progressPath,
            color = strokeColor,
            style = Stroke(width = strokeWidth)
        )
        drawCircle(
            color = strokeColor,
            center = circleHeadOffset,
            radius = innerCircleRadius
        )
        drawCircle(
            color = cardBackground,
            center = circleHeadOffset,
            radius = outerCircleRadius
        )
        drawText(
            textLayoutResult = textLayoutResult,
            topLeft = Offset(
                (size.width - textLayoutResult.size.width).div(2),
                (size.height - textLayoutResult.size.height).div(2)
            )
        )

    }
}