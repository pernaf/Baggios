package com.example.baggios.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.baggios.screenshome.HomeScreen
import com.example.baggios.ui.screens.contacts.ContactsScreen
import com.example.baggios.ui.screens.discography.DiscographyScreen
import com.example.baggios.ui.screens.release.ReleaseScreen
import com.example.baggios.ui.screens.rider.RiderScreen
import com.example.baggios.ui.screens.shows.ShowsScreen
import com.example.baggios.ui.screens.social.SocialScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(Screen.Home.route) {
            HomeScreen(onNavigate = { route ->
                navController.navigate(route)
            })
        }

        composable(Screen.Release.route) {
            ReleaseScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Contacts.route) {
            ContactsScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Social.route) {
            SocialScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Discography.route) {
            DiscographyScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Shows.route) {
            ShowsScreen(onBack = { navController.popBackStack() })
        }

        composable(Screen.Rider.route) {
            RiderScreen(onBack = { navController.popBackStack() })
        }

    }
}