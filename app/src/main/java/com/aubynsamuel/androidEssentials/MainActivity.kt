package com.aubynsamuel.androidEssentials

import android.R
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aubynsamuel.androidEssentials.presentation.screens.AnimatedCarousel
import com.aubynsamuel.androidEssentials.presentation.screens.MainScreen
import com.aubynsamuel.androidEssentials.presentation.screens.PullToRefreshScreen
import com.aubynsamuel.androidEssentials.presentation.screens.SearchBar
import com.aubynsamuel.androidEssentials.presentation.screens.TopApBarScreen
import com.aubynsamuel.androidEssentials.presentation.theme.CardItTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.S)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.content)) { view, insets ->
            val bottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            view.updatePadding(bottom = bottom)
            insets
        }
        setContent {
            CardItTheme {
                Navigation()
            }
        }
    }
}

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
    }
}

data class NavItem(val route: String, val name: String)

val navList = listOf<NavItem>(
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
    )
)

object AppRoutes {
    const val PULL_TO_REFRESH = "pullToRefresh"
    const val MAIN_SCREEN = "mainScreen"
    const val SEARCH_BAR = "searchBar"
    const val TOP_HEADER_BAR = "topHeaderBar"
    const val ANIMATED_CAROUSEL = "animatedCarousel"
}