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

data class NavItem(val route: Any, val name: String, val icon: ImageVector, val category: String)

val navList = listOf(
    NavItem(
        route = TopHeaderBar,
        name = "Top App Bar",
        icon = Icons.Default.Menu,
        category = "Bars & Navigation"
    ),
    NavItem(
        route = PullToRefresh,
        name = "Pull to refresh",
        icon = Icons.Default.Refresh,
        category = "Layouts"
    ),
    NavItem(
        route = SearchBar,
        name = "Search bar",
        icon = Icons.Default.Search,
        category = "Bars & Navigation"
    ),
    NavItem(
        route = AnimatedCarousel,
        name = "Carousel",
        icon = Icons.Default.ViewCarousel,
        category = "Layouts"
    ),
    NavItem(
        route = BottomSheetScaffold,
        name = "Bottom Sheet Scaffold",
        icon = Icons.Default.SpaceBar,
        category = "Layouts"
    ),
    NavItem(
        route = BottomSheet,
        name = "Bottom Sheet",
        icon = Icons.Default.ExpandMore,
        category = "Layouts"
    ),
    NavItem(
        route = SnackBar,
        name = "Snack Bar",
        icon = Icons.Default.Info,
        category = "Bars & Navigation"
    ),
    NavItem(
        route = MovingGesture,
        name = "Moving Gesture",
        icon = Icons.Default.Gesture,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = ProgressIndicators,
        name = "Progress Indicators",
        icon = Icons.Default.HourglassTop,
        category = "Components"
    ),
    NavItem(
        route = ButtonsScreen,
        name = "Buttons",
        icon = Icons.Default.SmartButton,
        category = "Components"
    ),
    NavItem(
        route = ShapesScreen,
        name = "Shapes",
        icon = Icons.Default.Category,
        category = "Components"
    ),
    NavItem(
        route = FloatingActionButton,
        name = "Floating Action Button",
        icon = Icons.Default.AddBox,
        category = "Bars & Navigation"
    ),
    NavItem(
        route = TextGradientsScreen,
        name = "Text Gradient",
        icon = Icons.Default.FormatColorText,
        category = "Components"
    ),
    NavItem(
        route = PillIndicatorScreen,
        name = "Pill Progress Indicator",
        icon = Icons.Default.HourglassBottom,
        category = "Components"
    ),
    NavItem(
        route = RevealAnimationScreen,
        name = "Reveal Animation",
        icon = Icons.Default.Waves,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = FlipAnimation,
        name = "Flip Animation",
        icon = Icons.Default.Flip,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = CardSlideAnimation,
        name = "Card Slide Animation",
        icon = Icons.Default.Slideshow,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = ReflectionAnimation,
        name = "Reflection Animation",
        icon = Icons.Default.RollerShades,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = SweepLineAnimation,
        name = "Sweep Line Animation",
        icon = Icons.Default.LineAxis,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = CircularRevealAnimation,
        name = "Circular Reveal Animation",
        icon = Icons.Default.HideImage,
        category = "Animations & Gestures"
    ),
    NavItem(
        route = ListAnimation,
        name = "List Animation",
        icon = Icons.Default.FilterList,
        category = "Animations & Gestures"
    )
)