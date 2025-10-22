package com.aubynsamuel.androidEssentials.presentation.screens.bars_and_navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ToggleOff
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFlexibleTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aubynsamuel.skeletonloader.modifiers.shimmerPlaceholder
import kotlinx.coroutines.delay

@RequiresApi(Build.VERSION_CODES.S)
@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun TopApBarScreen() {
    val scrollState = rememberScrollState()
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    var isLoading by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        delay(5000)
        isLoading = false
    }

    Scaffold(
        topBar = {
            LargeFlexibleTopAppBar(
                expandedHeight = 200.dp,
                title = {
                    Text(text = "Hello World")
                },
                scrollBehavior = scrollBehavior,
                actions = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Default.ToggleOff, contentDescription = "")
                    }
                }
            )

        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { inner ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(inner)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to CardIt",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .shimmerPlaceholder(isLoading)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .size(200.dp)
                    .shimmerPlaceholder(isLoading, shape = CircleShape)
                    .background(Color.Red)
            )

            repeat(10) { index ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .shimmerPlaceholder(isLoading)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text(
                            text = "Card Item ${index + 1}",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                                .shimmerPlaceholder(isLoading)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "This is some sample content for card ${index + 1}. It contains generic information that you can replace later with actual content.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .shimmerPlaceholder(isLoading)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Button(
                            onClick = { },
                            modifier = Modifier
                                .align(Alignment.End)
                                .shimmerPlaceholder(isLoading)

                        ) {
                            Text("Action ${index + 1}")
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { },
                modifier = Modifier
                    .fillMaxWidth()
                    .shimmerPlaceholder(isLoading)
            ) {
                Text("Load More")
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.S)
@Preview
@Composable
fun TopApBarScreenPreview() {
    TopApBarScreen()
}