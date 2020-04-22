package com.sudo.rizwan.twitterclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.ui.animation.Crossfade
import androidx.ui.core.setContent
import androidx.ui.material.MaterialTheme
import androidx.ui.material.Surface
import com.sudo.rizwan.twitterclone.screens.Home
import com.sudo.rizwan.twitterclone.screens.Profile
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.state.Screen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colors = AppState.theme) {
                AppContent()
            }
        }
    }
}

@Composable
fun AppContent() {
    Crossfade(AppState.currentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                is Screen.Home -> Home()
                is Screen.Profile -> Profile()
            }
        }
    }
}
