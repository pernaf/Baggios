package com.example.baggios.navigation

sealed class Screen(val route: String) {
    object Home        : Screen("home")
    object Release     : Screen("release")
    object Photos      : Screen("photos")
    object Rider       : Screen("rider")
    object Discography : Screen("discography")
    object Shows       : Screen("shows")
    object Contacts    : Screen("contacts")
    object Social      : Screen("social")
}