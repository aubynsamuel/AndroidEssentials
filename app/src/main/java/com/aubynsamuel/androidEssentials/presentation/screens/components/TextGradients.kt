package com.aubynsamuel.androidEssentials.presentation.screens.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aubynsamuel.androidEssentials.BuildConfig

@Composable
fun TextGradients() {
    val names = remember { BuildConfig.names }
    val namesList = remember { names.split("+") }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                namesList[0],
                fontFamily = FontFamily.Serif,
                fontSize = 50.sp,
                style = TextStyle(
                    brush = Brush.sweepGradient(
                        listOf(
                            Color.Magenta,
                            Color.Red,
                            Color.Yellow,
                            Color.Cyan,
                        )
                    )
                ),
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Text(
                namesList[1],
                fontFamily = FontFamily.Serif,
                fontSize = 50.sp,
                style = TextStyle(
                    brush = Brush.linearGradient(
                        listOf(
                            Color.Yellow,
                            Color.Green,
                            Color.Blue,
                        )
                    )
                ),
                modifier = Modifier.padding(vertical = 20.dp)
            )
            Text(
                namesList[2],
                fontFamily = FontFamily.Serif,
                fontSize = 50.sp,
                style = TextStyle(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.DarkGray,
                            Color.Gray,
                            Color.LightGray,
                            Color.White
                        )
                    )
                ),
                modifier = Modifier.padding(vertical = 20.dp)
            )
        }
    }
}