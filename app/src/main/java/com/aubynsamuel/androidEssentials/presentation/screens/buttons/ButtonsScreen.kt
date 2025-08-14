package com.aubynsamuel.androidEssentials.presentation.screens.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DynamicForm
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedToggleButton
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.FilledTonalIconToggleButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.ToggleButton
import androidx.compose.material3.TonalToggleButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun Buttons() {
    Scaffold { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {

            // M3 Expressive
            ToggleButton(onCheckedChange = {}, checked = false) {
                Text("ToggleButton")
            }

            // M3 Expressive
            TonalToggleButton(
                checked = true,
                onCheckedChange = {}
            ) {
                Text("TonalToggleButton")
            }

            // M3 Expressive
            ElevatedToggleButton(checked = true, onCheckedChange = {}) {
                Text("ElevatedToggleButton")
            }

            Button({}) {
                Text("Normal Button")
            }

            ElevatedButton({}) {
                Text("ElevatedButton")
            }

            FilledTonalButton({}) {
                Text("FilledTonalButton")
            }

            var filledTonalToggle by remember { mutableStateOf(false) }
            FilledTonalIconToggleButton(
                checked = filledTonalToggle,
                onCheckedChange = { filledTonalToggle = !filledTonalToggle }) {
                Icon(Icons.Default.DynamicForm, contentDescription = "")
            }

            FilledTonalIconButton({}) {
                Icon(Icons.Default.Build, contentDescription = "")
            }

            OutlinedIconButton({}) {
                Icon(Icons.Default.DynamicForm, contentDescription = "")
            }
        }
    }
}