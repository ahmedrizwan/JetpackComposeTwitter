package com.sudo.rizwan.twitterclone.ui.home

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.layout.preferredSize
import androidx.ui.material.FloatingActionButton
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.state.Screen
import com.sudo.rizwan.twitterclone.state.navigateTo

@Composable
fun Fab() {
    FloatingActionButton(
        onClick = { navigateTo(Screen.Compose) },
        backgroundColor = AppState.theme.primary
    ) {
        Image(
            imageResource(R.drawable.ic_compose),
            modifier = Modifier
                .preferredSize(25.dp)
        )
    }
}
