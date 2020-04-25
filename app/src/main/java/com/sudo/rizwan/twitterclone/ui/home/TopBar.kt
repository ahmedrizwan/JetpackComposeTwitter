package com.sudo.rizwan.twitterclone.ui.home

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.DrawerState
import androidx.ui.material.ScaffoldState
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.state.AppState

@Composable
fun TopBar(scaffoldState: ScaffoldState) {
    Surface(elevation = 2.dp, color = AppState.theme.surface) {
        Row(
            modifier = Modifier.preferredHeight(50.dp).padding(start = 16.dp, end = 16.dp).fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalGravity = Alignment.CenterVertically
        ) {
            Clickable(onClick = { scaffoldState.drawerState = DrawerState.Opened }) {
                Image(
                    imageResource(R.drawable.profile_image),
                    modifier = Modifier.preferredSize(34.dp).clip(shape = RoundedCornerShape(17.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Image(imageResource(R.drawable.ic_twitter), modifier = Modifier.preferredSize(22.dp))
            Image(imageResource(R.drawable.ic_trends), modifier = Modifier.preferredSize(24.dp))
        }
    }
}

