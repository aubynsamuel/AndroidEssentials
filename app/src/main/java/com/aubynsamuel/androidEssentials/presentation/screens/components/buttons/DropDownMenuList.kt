package com.aubynsamuel.androidEssentials.presentation.screens.buttons

import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DropDownMenuList(expanded: Boolean = false, onDisMisRequest: () -> Unit) {
    DropdownMenu(
        expanded,
        onDismissRequest = { onDisMisRequest() }
    ) {
        DropdownMenuItem(
            text = { Text("Menu Item 1") },
            onClick = { onDisMisRequest() }
        )
        DropdownMenuItem(
            text = { Text("Menu Item 2") },
            onClick = { onDisMisRequest() }
        )
        DropdownMenuItem(
            text = { Text("Menu Item 3") },
            onClick = { onDisMisRequest() }
        )
    }
}