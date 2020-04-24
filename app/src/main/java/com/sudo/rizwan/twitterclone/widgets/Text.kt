package com.sudo.rizwan.twitterclone.widgets

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.text.TextStyle
import com.sudo.rizwan.twitterclone.state.AppState

@Composable
fun ThemedText(text: String, style: TextStyle = TextStyle()) {
    Text(
        text = text,
        style = style,
        color = if (AppState.theme.isLight) Color(0xFF111111) else Color(0xFFEEEEEE)
    )
}