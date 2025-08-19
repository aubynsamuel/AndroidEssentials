package com.aubynsamuel.androidEssentials.presentation.navigation

data class NavItem(val route: String, val name: String)

val navList = listOf(
    NavItem(
        route = AppRoutes.TOP_HEADER_BAR,
        name = "Top App Bar"
    ),
    NavItem(
        route = AppRoutes.PULL_TO_REFRESH,
        name = "Pull to refresh"
    ),
    NavItem(
        route = AppRoutes.SEARCH_BAR,
        name = "Search bar"
    ),
    NavItem(
        route = AppRoutes.ANIMATED_CAROUSEL,
        name = "Carousel"
    ),
    NavItem(
        route = AppRoutes.BOTTOM_SHEET_SCAFFOLD,
        name = "Bottom Sheet Scaffold"
    ),
    NavItem(
        route = AppRoutes.BOTTOM_SHEET,
        name = "Bottom Sheet"
    ),
    NavItem(
        route = AppRoutes.SNACK_BAR,
        name = "Snack Bar"
    ),
    NavItem(
        route = AppRoutes.MOVING_GESTURE,
        name = "Moving Gesture"
    ),
    NavItem(
        route = AppRoutes.PROGRESS_INDICATORS,
        name = "Progress Indicators"
    ),
    NavItem(
        route = AppRoutes.BUTTONS,
        name = "Buttons Screen"
    ),
    NavItem(
        route = AppRoutes.SHAPES,
        name = "Shapes Screen"
    )
)