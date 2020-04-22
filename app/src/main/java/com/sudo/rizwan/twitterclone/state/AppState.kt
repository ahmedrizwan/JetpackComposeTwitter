package com.sudo.rizwan.twitterclone.state

import androidx.compose.Model

sealed class Screen {
    object Home : Screen()
    data class Profile(val profileId: Int) : Screen()
}

@Model
object AppState {
    var currentScreen: Screen = Screen.Home
}