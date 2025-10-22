package com.aubynsamuel.androidEssentials.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Flip
import androidx.compose.material.icons.filled.FormatColorText
import androidx.compose.material.icons.filled.Gesture
import androidx.compose.material.icons.filled.HideImage
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material.icons.filled.HourglassTop
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.LineAxis
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.RollerShades
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Slideshow
import androidx.compose.material.icons.filled.SmartButton
import androidx.compose.material.icons.filled.SpaceBar
import androidx.compose.material.icons.filled.ViewCarousel
import androidx.compose.material.icons.filled.Waves
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
        route = RevealAnimationScreen,
        name = "Reveal Animation",
        icon = Icons.Default.Waves,
    ),
    NavItem(
        route = FlipAnimation,
        name = "Flip Animation",
        icon = Icons.Default.Flip,
    ),
    NavItem(
        route = CardSlideAnimation,
        name = "Card Slide Animation",
        icon = Icons.Default.Slideshow,
    ),
    NavItem(
        route = ReflectionAnimation,
        name = "Reflection Animation",
        icon = Icons.Default.RollerShades,
    ),
    NavItem(
        route = SweepLineAnimation,
        name = "Sweep Line Animation",
        icon = Icons.Default.LineAxis,
    ),
    NavItem(
        route = CircularRevealAnimation,
        name = "Circular Reveal Animation",
        icon = Icons.Default.HideImage,
    ),
    NavItem(
        route = ListAnimation,
        name = "List Animation",
        icon = Icons.Default.FilterList,
    )
)