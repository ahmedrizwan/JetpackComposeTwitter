package com.sudo.rizwan.twitterclone

import androidx.ui.graphics.Color
import androidx.ui.material.darkColorPalette
import androidx.ui.material.lightColorPalette

private val lightBackgroundColor = Color.White
private val darkBackgroundColor = Color(0xFF15202b)
private val darkerBackgroundColor = Color(0xFF0a0a0a)
private val primaryColor = Color(0xFF08a0e9)

val lightThemeColors = lightColorPalette(
    primary = primaryColor,
    background = lightBackgroundColor,
    surface = lightBackgroundColor
)

val darkThemeColors = darkColorPalette(
    primary = primaryColor,
    background = darkBackgroundColor,
    surface = darkBackgroundColor
)

val darkerThemeColors = darkColorPalette(
    primary = primaryColor,
    background = darkerBackgroundColor,
    surface = darkerBackgroundColor
)