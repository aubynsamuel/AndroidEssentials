package com.aubynsamuel.androidEssentials.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Gesture
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SmartButton
import androidx.compose.material.icons.filled.SpaceBar
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val route: String, val name: String, val icon: ImageVector)

val navList = listOf(
    NavItem(
        route = AppRoutes.TOP_HEADER_BAR,
        name = "Top App Bar",
        icon = Icons.Default.Menu,
    ),
    NavItem(
        route = AppRoutes.PULL_TO_REFRESH,
        name = "Pull to refresh",
        icon = Icons.Default.Refresh,
    ),
    NavItem(
        route = AppRoutes.SEARCH_BAR,
        name = "Search bar",
        icon = Icons.Default.Search,
    ),
    NavItem(
        route = AppRoutes.ANIMATED_CAROUSEL,
        name = "Carousel",
        icon = Icons.Default.ViewCarousel,
    ),
    NavItem(
        route = AppRoutes.BOTTOM_SHEET_SCAFFOLD,
        name = "Bottom Sheet Scaffold",
        icon = Icons.Default.SpaceBar,
    ),
    NavItem(
        route = AppRoutes.BOTTOM_SHEET,
        name = "Bottom Sheet",
        icon = Icons.Default.ExpandMore,
    ),
    NavItem(
        route = AppRoutes.SNACK_BAR,
        name = "Snack Bar",
        icon = Icons.Default.Info,
    ),
    NavItem(
        route = AppRoutes.MOVING_GESTURE,
        name = "Moving Gesture",
        icon = Icons.Default.Gesture,
    ),
    NavItem(
        route = AppRoutes.PROGRESS_INDICATORS,
        name = "Progress Indicators",
        icon = Icons.Default.HourglassTop,
    ),
    NavItem(
        route = AppRoutes.BUTTONS,
        name = "Buttons",
        icon = Icons.Default.SmartButton,
    ),
    NavItem(
        route = AppRoutes.SHAPES,
        name = "Shapes",
        icon = Icons.Default.Category,
    ),
    NavItem(
        route = AppRoutes.FAB,
        name = "Floating Action Button",
        icon = Icons.Default.AddBox,
    )
)