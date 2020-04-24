package com.sudo.rizwan.twitterclone.state

import androidx.compose.Model
import com.sudo.rizwan.twitterclone.lightThemeColors
import com.sudo.rizwan.twitterclone.models.User

sealed class Screen {
    object Home : Screen()
    data class Profile(val user: User) : Screen()
    object Compose : Screen()
}

@Model
object AppState {
    var currentScreen: Screen = Screen.Home
    var theme = lightThemeColors
}

fun navigateTo(destination: Screen) {
    AppState.currentScreen = destination
}

fun isLightTheme(): Boolean {
    return AppState.theme.isLight
}
