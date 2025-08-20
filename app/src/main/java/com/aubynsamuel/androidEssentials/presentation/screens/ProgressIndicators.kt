package com.aubynsamuel.androidEssentials.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ElevatedToggleButton
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

const val maxProgress = 60

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun ProgressIndicators() {
    var progress: Float by remember { mutableFloatStateOf(25F) }
    val animatedProgress by
    animateFloatAsState(
        targetValue = progress / maxProgress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )
    var isPlaying by remember { mutableStateOf(false) }

    LaunchedEffect(isPlaying) {
        while (isPlaying) {
            if (progress >= maxProgress) {
                isPlaying = false
                break
            }
            progress += 0.01f
            delay(10)
        }
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(contentAlignment = Alignment.Center) {
                CircularWavyProgressIndicator(
                    progress = { animatedProgress },
                    modifier = Modifier.size(200.dp),
//                    color = MaterialTheme.colorScheme.error,
//                    trackColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    stroke = Stroke(width = 30f),
                    trackStroke = Stroke(width = 30f),
                    wavelength = 30.dp
                )
                Text(
                    progress.toInt().toString(),
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 30.sp,
                    fontStyle = FontStyle.Italic,
                    fontFamily = FontFamily.Cursive,
                    autoSize = TextAutoSize.StepBased(maxFontSize = 70.sp),
                    modifier = Modifier
                        .padding(end = 25.dp)
                )
            }

            LinearWavyProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.fillMaxWidth(0.8f),
//                color = MaterialTheme.colorScheme.error,
//                trackColor = MaterialTheme.colorScheme.primary,
                wavelength = 25.dp
            )

            Slider(
                value = progress,
                onValueChange = { progress = it },
                valueRange = 0f..maxProgress.toFloat(),
                steps = 59
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                ElevatedToggleButton(
                    modifier = Modifier
                        .width(120.dp)
                        .height(70.dp),
                    checked = isPlaying,
                    onCheckedChange = {
                        if (progress >= maxProgress) {
                            progress = 0f
                        }
                        isPlaying = !isPlaying
                    }) {
                    Text(
                        if (progress >= maxProgress) "Play Again"
                        else if (isPlaying) "Pause"
                        else "Play", fontSize = 18.sp
                    )
                }
                ElevatedToggleButton(
                    modifier = Modifier
                        .width(120.dp)
                        .height(70.dp),
                    onCheckedChange = { progress = 0f },
                    checked = progress != 0f
                ) {
                    Text("Reset", fontSize = 18.sp)
                }
            }
        }
    }
}