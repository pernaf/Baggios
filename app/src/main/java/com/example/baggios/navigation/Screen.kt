package com.example.baggios.navigation

sealed class Screen(val route: String) {
    data object Home        : Screen("home")
    data object Release     : Screen("release")
    data object Photos      : Screen("photos")
    data object Rider       : Screen("rider")
    data object Discography : Screen("discography")
    data object Shows       : Screen("shows")
    data object Contacts    : Screen("contacts")
    data object Social      : Screen("social")
}