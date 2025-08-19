package com.aubynsamuel.androidEssentials.presentation.screens

import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.MaterialShapes
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.toShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3ExpressiveApi::class, ExperimentalMaterial3Api::class)
@Composable
fun ShapesScreen() {
    val shapeSize by remember { mutableIntStateOf(80) }
    val shapesList = remember {
        setOf(
            MaterialShapes.Arch to "Arch",
            MaterialShapes.Arrow to "Arrow",
            MaterialShapes.Burst to "Burst",
            MaterialShapes.Boom to "Boom",
            MaterialShapes.Bun to "Bun",
            MaterialShapes.ClamShell to "ClamShell",
            MaterialShapes.Circle to "Circle",
            MaterialShapes.Clover4Leaf to "Clover4Leaf",
            MaterialShapes.Clover8Leaf to "Clover8Leaf",
            MaterialShapes.Cookie4Sided to "Cookie4Sided",
            MaterialShapes.Cookie6Sided to "Cookie6Sided",
            MaterialShapes.Cookie7Sided to "Cookie7Sided",
            MaterialShapes.Cookie9Sided to "Cookie9Sided",
            MaterialShapes.Cookie12Sided to "Cookie12Sided",
            MaterialShapes.Diamond to "Diamond",
            MaterialShapes.Fan to "Fan",
            MaterialShapes.Flower to "Flower",
            MaterialShapes.Ghostish to "Ghostish",
            MaterialShapes.Gem to "Gem",
            MaterialShapes.Heart to "Heart",
            MaterialShapes.Oval to "Oval",
            MaterialShapes.PuffyDiamond to "PuffyDiamond",
            MaterialShapes.Puffy to "Puffy",
            MaterialShapes.Pill to "Pill",
            MaterialShapes.PixelTriangle to "PixelTriangle",
            MaterialShapes.Pentagon to "Pentagon",
            MaterialShapes.PixelCircle to "PixelCircle",
            MaterialShapes.Sunny to "Sunny",
            MaterialShapes.SemiCircle to "SemiCircle",
            MaterialShapes.SoftBurst to "SoftBurst",
            MaterialShapes.Square to "Square",
            MaterialShapes.Slanted to "Slanted",
            MaterialShapes.SoftBoom to "SoftBoom",
            MaterialShapes.Triangle to "Triangle",
            MaterialShapes.VerySunny to "VerySunny",
        )
    }

    Scaffold(topBar = { TopAppBar(title = { Text("Shapes") }) }) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            itemsIndexed(shapesList.toList()) { index, shape ->
                Column(
                    modifier = Modifier.padding(5.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(
                        modifier = Modifier
                            .size(shapeSize.dp)
                            .border(
                                shape = shape.first.toShape(),
                                width = 3.dp,
                                color = MaterialTheme.colorScheme.onBackground
                            ),
                        contentAlignment = Alignment.Center
                    ) {}
                    Spacer(Modifier.height(5.dp))
                    Text(
                        text = shape.second,
                        style = TextStyle().copy(
                            fontSize = 14.sp
                        ),
                        modifier = Modifier.basicMarquee()
                    )
                    Spacer(Modifier.height(20.dp))
                }
            }
        }
    }
}