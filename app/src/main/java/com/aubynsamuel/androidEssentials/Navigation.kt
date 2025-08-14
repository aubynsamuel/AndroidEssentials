package com.aubynsamuel.androidEssentials

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aubynsamuel.androidEssentials.presentation.screens.AnimatedCarousel
import com.aubynsamuel.androidEssentials.presentation.screens.BottomSheet
import com.aubynsamuel.androidEssentials.presentation.screens.BottomSheetScaffold
import com.aubynsamuel.androidEssentials.presentation.screens.MainScreen
import com.aubynsamuel.androidEssentials.presentation.screens.MovingGestureScreen
import com.aubynsamuel.androidEssentials.presentation.screens.ProgressIndicators
import com.aubynsamuel.androidEssentials.presentation.screens.PullToRefreshScreen
import com.aubynsamuel.androidEssentials.presentation.screens.SearchBar
import com.aubynsamuel.androidEssentials.presentation.screens.SnackBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.TopApBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.buttons.Buttons

object AppRoutes {
    const val PULL_TO_REFRESH = "pullToRefresh"
    const val MAIN_SCREEN = "mainScreen"
    const val SEARCH_BAR = "searchBar"
    const val TOP_HEADER_BAR = "topHeaderBar"
    const val ANIMATED_CAROUSEL = "animatedCarousel"
    const val BOTTOM_SHEET_SCAFFOLD = "bottomSheetScaffold"
    const val BOTTOM_SHEET = "bottomSheet"
    const val SNACK_BAR = "snackBar"
    const val MOVING_GESTURE = "movingGesture"
    const val PROGRESS_INDICATORS = "progressIndicators"
    const val BUTTONS = "buttons"
}

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
)


@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRoutes.MAIN_SCREEN) {
        composable(AppRoutes.MAIN_SCREEN) {
            MainScreen(navController = navController)
        }
        composable(AppRoutes.TOP_HEADER_BAR) {
            TopApBarScreen()
        }
        composable(AppRoutes.PULL_TO_REFRESH) {
            PullToRefreshScreen()
        }
        composable(AppRoutes.SEARCH_BAR) {
            SearchBar()
        }
        composable(AppRoutes.ANIMATED_CAROUSEL) {
            AnimatedCarousel()
        }
        composable(AppRoutes.BOTTOM_SHEET_SCAFFOLD) {
            BottomSheetScaffold()
        }
        composable(AppRoutes.BOTTOM_SHEET) {
            BottomSheet()
        }
        composable(AppRoutes.SNACK_BAR) {
            SnackBarScreen()
        }
        composable(AppRoutes.MOVING_GESTURE) {
            MovingGestureScreen()
        }
        composable(AppRoutes.PROGRESS_INDICATORS) {
            ProgressIndicators()
        }
        composable(AppRoutes.BUTTONS) {
            Buttons()
        }
    }
}