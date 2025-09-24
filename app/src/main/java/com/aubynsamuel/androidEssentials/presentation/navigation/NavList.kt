package com.aubynsamuel.androidEssentials.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.FormatColorText
import androidx.compose.material.icons.filled.Gesture
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.SmartButton
import androidx.compose.material.icons.filled.SpaceBar
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem(val route: Any, val name: String, val icon: ImageVector)

val navList = listOf(
    NavItem(
        route = TopHeaderBar,
        name = "Top App Bar",
        icon = Icons.Default.Menu,
    ),
    NavItem(
        route = PullToRefresh,
        name = "Pull to refresh",
        icon = Icons.Default.Refresh,
    ),
    NavItem(
        route = SearchBar,
        name = "Search bar",
        icon = Icons.Default.Search,
    ),
    NavItem(
        route = AnimatedCarousel,
        name = "Carousel",
        icon = Icons.Default.ViewCarousel,
    ),
    NavItem(
        route = BottomSheetScaffold,
        name = "Bottom Sheet Scaffold",
        icon = Icons.Default.SpaceBar,
    ),
    NavItem(
        route = BottomSheet,
        name = "Bottom Sheet",
        icon = Icons.Default.ExpandMore,
    ),
    NavItem(
        route = SnackBar,
        name = "Snack Bar",
        icon = Icons.Default.Info,
    ),
    NavItem(
        route = MovingGesture,
        name = "Moving Gesture",
        icon = Icons.Default.Gesture,
    ),
    NavItem(
        route = ProgressIndicators,
        name = "Progress Indicators",
        icon = Icons.Default.HourglassTop,
    ),
    NavItem(
        route = ButtonsScreen,
        name = "Buttons",
        icon = Icons.Default.SmartButton,
    ),
    NavItem(
        route = ShapesScreen,
        name = "Shapes",
        icon = Icons.Default.Category,
    ),
    NavItem(
        route = FloatingActionButton,
        name = "Floating Action Button",
        icon = Icons.Default.AddBox,
    ),
    NavItem(
        route = TextGradientsScreen,
        name = "Text Gradient",
        icon = Icons.Default.FormatColorText,
    ),
    NavItem(
        route = PillIndicatorScreen,
        name = "Pill Progress Indicator",
        icon = Icons.Default.HourglassBottom,
    ),
    NavItem(
        route = LoadingAnimationScreen,
        name = "Pill Progress Indicator",
        icon = Icons.Default.HourglassBottom,
    )
)