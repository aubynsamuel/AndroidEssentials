package com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseInSine
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.CompositingStrategy
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aubynsamuel.androidEssentials.R
import kotlinx.coroutines.launch

// Step 1: Main screen composable - sets up the basic UI structure with animations
@Composable
@Preview
fun LoadingAnimation() {
    // Step 1a: Create a coroutine scope for handling animations smoothly
    val scope = rememberCoroutineScope()

    // Step 1b: Set up infinite looping animation for wave movement (yOffset controls vertical shift)
    val infiniteTransition = rememberInfiniteTransition()
    val yOffset = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearEasing)  // Loops every 1 second linearly
        )
    )

    // Step 1c: Animatable for progress bar (0f to 1f) - controls how much of the wave is revealed
    val progress = remember { Animatable(0f) }

    // Step 1d: Define forward animation: slow linear progress over 10 seconds
    val forwardAnimationSpec = remember {
        tween<Float>(
            durationMillis = 10_000,
            easing = LinearEasing
        )
    }

    // Step 1e: Define reset animation: quick ease-in sine back to start in 1 second
    val resetAnimationSpec = remember {
        tween<Float>(
            durationMillis = 1_000,
            easing = EaseInSine
        )
    }

    // Step 2: Function to reset progress to 0 with smooth animation
    fun reset() {
        scope.launch {
            progress.stop()  // Stop any running animation
            progress.animateTo(0f, resetAnimationSpec)  // Animate back to 0
        }
    }

    // Step 3: Function to toggle play/pause - advances or stops the progress
    fun togglePlay() {
        scope.launch {
            if (progress.isRunning) {
                progress.stop()  // Pause if running
            } else {
                if (progress.value == 1f) {
                    progress.snapTo(0f)  // Reset instantly if at end
                }
                progress.animateTo(1f, forwardAnimationSpec)  // Play forward to 1
            }
        }
    }

    // Step 4: Main Box layout - full screen with padding and background
    Box(
        modifier = Modifier
            .fillMaxSize()
//            .padding(30.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {
        // Step 4a: Set content color provider for text/icons
        CompositionLocalProvider(LocalContentColor provides MaterialTheme.colorScheme.onBackground) {
            // Step 5: Main text with custom loading animation modifier
            Text(
                text = "Learn Compose\nby\nBOLT UIX.",
                modifier = Modifier
                    .align(Alignment.Center)
                    .loadingRevealAnimation(  // Apply wave reveal effect
                        progress = progress.asState(),
                        yOffset = yOffset
                    )
                    .padding(10.dp),
                fontSize = 75.sp,
                lineHeight = 90.sp,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.surfaceContainer
            )

            // Step 6: Bottom row for controls (reset and play/pause buttons)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(24.dp)
                    .safeContentPadding()
                    .align(Alignment.BottomCenter)
            ) {
                // Step 6a: Reset button with skip-back icon
                FilledIconButton(onClick = ::reset) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_skip_back),
                        contentDescription = null
                    )
                }

                // Step 6b: Play/Pause button with animated icon and text
                Button(onClick = ::togglePlay) {
                    AnimatedContent(  // Animate icon change based on state
                        label = "playbackButton",
                        targetState = progress.isRunning
                    ) { isPlaying ->
                        val icon = if (isPlaying) R.drawable.ic_pause else R.drawable.ic_play
                        Icon(
                            imageVector = ImageVector.vectorResource(icon),
                            contentDescription = null
                        )
                    }
                    Text(text = if (progress.isRunning) "Pause" else "Play")
                }
            }
        }
    }
}

// Step 7: Custom modifier for wave loading reveal effect - draws animated waves over text
private fun Modifier.loadingRevealAnimation(
    progress: State<Float>,  // How much to reveal (0-1)
    yOffset: State<Float>,   // Vertical wave shift for infinite motion
    wavesCount: Int = 2,     // Number of wave peaks (default 2)
    amplitudeProvider: (totalSize: Size) -> Float = { size -> size.minDimension * 0.1f },  // Wave height based on size
): Modifier = this
    // Step 7a: Use offscreen compositing to avoid glitches during drawing
    .graphicsLayer {
        compositingStrategy = CompositingStrategy.Offscreen
    }
    // Step 7b: Cache drawing for performance, with custom onDraw logic
    .drawWithCache {
        val height = size.height
        val waveLength = height / wavesCount  // Space between waves
        val nextPointOffset = waveLength / 2f  // Half wave for smooth curve
        val controlPointOffset = nextPointOffset / 2f  // Curve control point
        val amplitude = amplitudeProvider(size)  // Actual wave height
        val wavePath = Path()  // Path to draw the wave shape

        // Step 7c: Draw original content first (the text)
        onDrawWithContent {
            drawContent()

            // Step 7d: Calculate start position of wave based on progress (reveals from left)
            val waveStartX = (size.width + 2 * amplitude) * progress.value - amplitude

            // Step 7e: Build the wave path step by step
            wavePath.reset()
            wavePath.relativeLineTo(waveStartX, -waveLength)  // Start line up
            wavePath.relativeLineTo(
                0f,
                waveLength * yOffset.value
            )  // Shift vertically for animation

            // Step 7f: Repeat quadratic curves for each wave segment (zigzag up/down)
            repeat((wavesCount + 1) * 2) { i ->
                val direction = if (i and 1 == 0) -1 else 1  // Alternate up/down
                wavePath.relativeQuadraticTo(  // Smooth curve
                    dx1 = direction * amplitude,
                    dy1 = controlPointOffset,
                    dx2 = 0f,
                    dy2 = nextPointOffset
                )
            }

            // Step 7g: Close the path to bottom-left for full shape
            wavePath.lineTo(0f, height)
            wavePath.close()

            // Step 7h: Draw the path with colorful gradient brush and blend mode (masks over text)
            drawPath(
                path = wavePath,
                brush = Brush.linearGradient(  // Multi-color gradient for shiny effect
                    colorStops = arrayOf(
                        0.0f to Color(0xFF00C6FF),  // Aqua Blue start
                        0.3f to Color(0xFF0072FF),  // Deep Blue
                        0.6f to Color(0xFF7B2FF7),  // Purple Glow
                        0.85f to Color(0xFFFF0080), // Hot Pink
                        1f to Color(0xFFFFD200),    // Golden Yellow end
                    )
                ),
                blendMode = BlendMode.SrcAtop  // Blend to reveal text underneath
            )
        }
    }