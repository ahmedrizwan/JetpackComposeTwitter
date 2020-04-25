package com.sudo.rizwan.twitterclone.ui.common

import androidx.compose.Composable
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.text.TextStyle
import androidx.ui.text.style.TextOverflow
import androidx.ui.unit.sp
import com.sudo.rizwan.twitterclone.state.AppState

@Composable
fun ThemedText(text: String, style: TextStyle = TextStyle()) {
    Text(
        text = text,
        style = style,
        color = if (AppState.theme.isLight) Color(0xFF111111) else Color(0xFFEEEEEE)
    )
}


@Composable
fun GrayText(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 14.sp,
            color = if (AppState.theme.isLight) Color(0xFF666666) else Color(0xFFDDDDDD)
        ),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis
    )
}
