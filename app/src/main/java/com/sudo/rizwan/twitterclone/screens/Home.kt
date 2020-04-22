package com.sudo.rizwan.twitterclone.screens

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Image
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R

@Composable
fun Home() {
    Column {
        TopBar()
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier.preferredHeight(50.dp) +
                Modifier.padding(start = 16.dp, end = 16.dp) +
                Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        Image(
            imageResource(R.drawable.profile_image),
            modifier = Modifier
                .preferredSize(30.dp)
                .clip(shape = RoundedCornerShape(15.dp)),
            contentScale = ContentScale.Crop
        )

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