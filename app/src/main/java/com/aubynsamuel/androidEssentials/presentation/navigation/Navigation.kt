package com.aubynsamuel.androidEssentials.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aubynsamuel.androidEssentials.presentation.screens.MainScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.CardSlideAnimationScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.CircularRevealAnimationScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.FlipAnimationScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.ListAnimationScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.LoadingAnimation
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.MovingGestureScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.ReflectionAnimationScreen
import com.aubynsamuel.androidEssentials.presentation.screens.animations_and_gestures.SweepLineAnimationScreen
import com.aubynsamuel.androidEssentials.presentation.screens.bars_and_navigation.FABScreen
import com.aubynsamuel.androidEssentials.presentation.screens.bars_and_navigation.SearchBar
import com.aubynsamuel.androidEssentials.presentation.screens.bars_and_navigation.SnackBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.bars_and_navigation.TopApBarScreen
import com.aubynsamuel.androidEssentials.presentation.screens.buttons.Buttons
import com.aubynsamuel.androidEssentials.presentation.screens.components.PillProgressIndicatorScreen
import com.aubynsamuel.androidEssentials.presentation.screens.components.ProgressIndicators
import com.aubynsamuel.androidEssentials.presentation.screens.components.ShapesScreen
import com.aubynsamuel.androidEssentials.presentation.screens.components.TextGradients
import com.aubynsamuel.androidEssentials.presentation.screens.layouts.BottomSheet
import com.aubynsamuel.androidEssentials.presentation.screens.layouts.BottomSheetScaffold
import com.aubynsamuel.androidEssentials.presentation.screens.layouts.PullToRefreshScreen
import com.aubynsamuel.androidEssentials.presentation.screens.layouts.carousel.AnimatedCarousel

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
        composable<PillIndicatorScreen> {
            PillProgressIndicatorScreen()
        }
        composable<RevealAnimationScreen> {
            LoadingAnimation()
        }
        composable<FlipAnimation> {
            FlipAnimationScreen()
        }
        composable<CardSlideAnimation> {
            CardSlideAnimationScreen()
        }
        composable<ReflectionAnimation> {
            ReflectionAnimationScreen()
        }
        composable<SweepLineAnimation> {
            SweepLineAnimationScreen()
        }
        composable<CircularRevealAnimation> {
            CircularRevealAnimationScreen()
        }
        composable<ListAnimation> {
            ListAnimationScreen()
        }
    }
}