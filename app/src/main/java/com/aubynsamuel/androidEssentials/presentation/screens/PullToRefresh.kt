package com.aubynsamuel.androidEssentials.presentation.screens

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults.LoadingIndicator
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Main Composable screen demonstrating custom pull-to-refresh.
 * It uses a LazyColumn for scrollable content and overlays a custom indicator.
 */
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun PullToRefreshScreen() {
    var isRefreshing by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()
    val refreshState = rememberPullToRefreshState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { inner ->
        PullToRefreshBox(
            modifier = Modifier.padding(inner),
            isRefreshing = isRefreshing,
            state = refreshState,
            onRefresh = {
                isRefreshing = true
                scope.launch {
                    delay(5000)
                    isRefreshing = false
                }
            },
            indicator = {
                LoadingIndicator(
                    modifier = Modifier
                        .align(Alignment.TopCenter),
                    isRefreshing = isRefreshing,
                    state = refreshState
                )
            }
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(50) { index ->
                    Text(
                        text = "List Item ${index + 1}",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp, vertical = 10.dp)
                            .background(Color.LightGray.copy(alpha = 0.2f))
                            .padding(8.dp)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                }
            }
        }
    }
}

/**
 * Custom Composable for the pull-to-refresh loading indicator.
 * It animates a circle based on the pull fraction and refreshing state.
 */
@Composable
fun CustomLoadingIndicator(
    modifier: Modifier = Modifier,
    isRefreshing: Boolean,
    pullFraction: Float,
) {
    val rotation by animateFloatAsState(
        targetValue = if (isRefreshing) 360f else pullFraction * 360f,
        animationSpec = if (isRefreshing) infiniteRepeatable(
            animation = tween(durationMillis = 1000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ) else spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "rotationAnimation"
    )

    val scale by animateFloatAsState(
        targetValue = when {
            isRefreshing -> 1f // Full size when refreshing
            pullFraction > 0 -> 0.5f + (pullFraction * 0.5f) // Scales from 0.5 to 1.0 as pulled
            else -> 0f // Hidden when not pulled
        },
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "scaleAnimation"
    )

    val color by animateColorAsState(
        targetValue = if (isRefreshing) MaterialTheme.colorScheme.primary else Color.Gray.copy(alpha = pullFraction),
        animationSpec = tween(durationMillis = 300),
        label = "colorAnimation"
    )

    if (scale > 0.01f) {
        Canvas(
            modifier = modifier
                .size(48.dp)
                .graphicsLayer {
                    rotationZ = rotation
                    scaleX = scale
                    scaleY = scale
                    alpha = scale
                }
        ) {
            drawCircle(
                color = color,
                radius = size.minDimension / 2f
            )
        }
    }
}
