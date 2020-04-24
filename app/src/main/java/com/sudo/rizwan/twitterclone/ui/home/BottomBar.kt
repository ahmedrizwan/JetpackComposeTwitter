package com.sudo.rizwan.twitterclone.ui.home

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Image
import androidx.ui.layout.Arrangement
import androidx.ui.layout.Row
import androidx.ui.layout.preferredSize
import androidx.ui.material.BottomAppBar
import androidx.ui.material.IconButton
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.state.AppState

@Composable
fun BottomBar() {
    BottomAppBar(backgroundColor = AppState.theme.surface) {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            BottomBarIcon(R.drawable.ic_home_selected)
            BottomBarIcon(R.drawable.ic_search)
            BottomBarIcon(R.drawable.ic_notifications)
            BottomBarIcon(R.drawable.ic_dm)
        }
    }
}

@Composable
private fun BottomBarIcon(icon: Int) {
    IconButton(onClick = {}) {
        Image(
            imageResource(icon),
            modifier = Modifier.preferredSize(24.dp)
        )
    }
}