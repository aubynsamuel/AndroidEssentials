package com.aubynsamuel.androidEssentials.presentation.screens.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3ExpressiveApi
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SplitButtonDefaults
import androidx.compose.material3.SplitButtonLayout
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3ExpressiveApi::class)
@Composable
fun SplitButtonLayoutComponent() {
    var menuShown by remember { mutableStateOf(false) }

    SplitButtonLayout(
        leadingButton = {
            SplitButtonDefaults.LeadingButton({}) {
                Text("Leading Button")
            }
        },
        trailingButton = {
            SplitButtonDefaults.TrailingButton(
                checked = menuShown,
                onCheckedChange = { menuShown = it }) {
                Icon(
                    imageVector = if (menuShown) Icons.Default.KeyboardArrowUp
                    else Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    modifier = Modifier.size(IconButtonDefaults.mediumIconSize)
                )
            }

            DropDownMenuList(
                expanded = menuShown,
                onDisMisRequest = { menuShown = false }
            )
        }
    )
}