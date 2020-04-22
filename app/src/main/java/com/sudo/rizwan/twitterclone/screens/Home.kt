package com.sudo.rizwan.twitterclone.screens

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.DrawerState
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.widgets.CustomDivider

@Composable
fun Home(scaffoldState: ScaffoldState = remember { ScaffoldState() }) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer()
        },
        bodyContent = { modifier ->
            Column {
                TopBar(scaffoldState = scaffoldState)
                CustomDivider()
            }
        }
    )
}

@Composable
fun AppDrawer() {
    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.preferredHeight(24.dp))
        Text(text = "Drawer")
    }
}

@Composable
fun TopBar(scaffoldState: ScaffoldState) {
    Row(
        modifier = Modifier.preferredHeight(50.dp) +
                Modifier.padding(start = 16.dp, end = 16.dp) +
                Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        Clickable(onClick = {
            scaffoldState.drawerState = DrawerState.Opened
        }) {
            Image(
                imageResource(R.drawable.profile_image),
                modifier = Modifier
                    .preferredSize(30.dp)
                    .clip(shape = RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop
            )
        }

        Image(
            imageResource(R.drawable.twitter_icon),
            modifier = Modifier
                .preferredSize(25.dp)
        )

        Image(
            imageResource(R.drawable.trends_icon),
            modifier = Modifier
                .preferredSize(25.dp)
        )
    }
}