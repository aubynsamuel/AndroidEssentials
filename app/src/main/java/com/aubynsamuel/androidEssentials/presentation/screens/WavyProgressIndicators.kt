package com.aubynsamuel.androidEssentials.presentation.screens

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularWavyProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.LinearWavyProgressIndicator
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

const val maxProgress = 60

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun WavyProgressIndicators() {
    var progress: Float by remember { mutableFloatStateOf(25F) }
    val animatedProgress by
    animateFloatAsState(
        targetValue = progress / maxProgress,
        animationSpec = ProgressIndicatorDefaults.ProgressAnimationSpec,
    )
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(isLoading) {
        while (isLoading) {
            progress += 0.01f
            delay(10)
            if (progress >= maxProgress)
                break
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
                    color = MaterialTheme.colorScheme.error,
                    trackColor = MaterialTheme.colorScheme.primary,
                    stroke = Stroke(width = 30f),
                    trackStroke = Stroke(width = 30f),
                    wavelength = 30.dp
                )
                Text(
                    progress.toInt().toString(),
                )
            }

            LinearWavyProgressIndicator(
                progress = { animatedProgress },
                modifier = Modifier.fillMaxWidth(0.8f),
                color = MaterialTheme.colorScheme.error,
                trackColor = MaterialTheme.colorScheme.primary,
                wavelength = 25.dp
            )

            Slider(
                value = progress,
                onValueChange = { progress = it },
                valueRange = 0f..maxProgress.toFloat(),
                steps = 59
            )

            Button({ isLoading = !isLoading }) {
                Text("Start $isLoading")
            }
        }
    }
}