package com.freecodecloud.composetutorial.presentation.util

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen("on_boarding_screen")
}
