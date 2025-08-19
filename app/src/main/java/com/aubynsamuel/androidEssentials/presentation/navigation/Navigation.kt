package com.aubynsamuel.androidEssentials.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aubynsamuel.androidEssentials.presentation.screens.BottomSheet
import com.aubynsamuel.androidEssentials.presentation.screens.BottomSheetScaffold
import com.aubynsamuel.androidEssentials.presentation.screens.MainScreen
import com.aubynsamuel.androidEssentials.presentation.screens.MovingGestureScreen
import com.aubynsamuel.androidEssentials.presentation.screens.ProgressIndicators
import com.aubynsamuel.androidEssentials.presentation.screens.PullToRefreshScreen
import com.aubynsamuel.androidEssentials.presentation.screens.SearchBar
import com.aubynsamuel.androidEssentials.presentation.screens.ShapesScreen
import com.aubynsamuel.androidEssentials.presentation.screens.SnackBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.TopApBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.buttons.Buttons
import com.aubynsamuel.androidEssentials.presentation.screens.carousel.AnimatedCarousel

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
        composable(AppRoutes.SHAPES) {
            ShapesScreen()
        }
    }
}