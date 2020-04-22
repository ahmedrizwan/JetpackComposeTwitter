package com.sudo.rizwan.twitterclone.state

import androidx.compose.Model
import com.sudo.rizwan.twitterclone.lightThemeColors

sealed class Screen {
    object Home : Screen()
    data class Profile(val profileId: Int) : Screen()
}

@Model
object AppState {
    var currentScreen: Screen = Screen.Home
    var theme = lightThemeColors
}