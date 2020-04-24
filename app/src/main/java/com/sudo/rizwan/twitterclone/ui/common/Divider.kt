package com.sudo.rizwan.twitterclone.ui.common

import androidx.compose.Composable
import androidx.ui.graphics.Color
import androidx.ui.material.Divider
import com.sudo.rizwan.twitterclone.state.isLightTheme

@Composable
fun CustomDivider() {
    Divider(color = if (isLightTheme()) Color(0xFFEEEEEE) else Color(0xFF333333))
}