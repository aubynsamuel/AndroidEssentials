package com.aubynsamuel.androidEssentials.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aubynsamuel.androidEssentials.presentation.screens.BottomSheet
import com.aubynsamuel.androidEssentials.presentation.screens.BottomSheetScaffold
import com.aubynsamuel.androidEssentials.presentation.screens.FABScreen
import com.aubynsamuel.androidEssentials.presentation.screens.MainScreen
import com.aubynsamuel.androidEssentials.presentation.screens.MovingGestureScreen
import com.aubynsamuel.androidEssentials.presentation.screens.ProgressIndicators
import com.aubynsamuel.androidEssentials.presentation.screens.PullToRefreshScreen
import com.aubynsamuel.androidEssentials.presentation.screens.SearchBar
import com.aubynsamuel.androidEssentials.presentation.screens.ShapesScreen
import com.aubynsamuel.androidEssentials.presentation.screens.SnackBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.TextGradients
import com.aubynsamuel.androidEssentials.presentation.screens.TopApBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.buttons.Buttons
import com.aubynsamuel.androidEssentials.presentation.screens.carousel.AnimatedCarousel

@RequiresApi(Build.VERSION_CODES.S)
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MainScreen) {
        composable<MainScreen> {
            MainScreen(navController = navController)
        }
        composable<TopHeaderBar> {
            TopApBarScreen()
        }
        composable<PullToRefresh> {
            PullToRefreshScreen()
        }
        composable<SearchBar> {
            SearchBar()
        }
        composable<AnimatedCarousel> {
            AnimatedCarousel()
        }
        composable<BottomSheetScaffold> {
            BottomSheetScaffold()
        }
        composable<BottomSheet> {
            BottomSheet()
        }
        composable<SnackBar> {
            SnackBarScreen()
        }
        composable<MovingGesture> {
            MovingGestureScreen()
        }
        composable<ProgressIndicators> {
            ProgressIndicators()
        }
        composable<ButtonsScreen> {
            Buttons()
        }
        composable<ShapesScreen> {
            ShapesScreen()
        }
        composable<FloatingActionButton> {
            FABScreen()
        }
        composable<TextGradientsScreen> {
            TextGradients()
        }
    }
}