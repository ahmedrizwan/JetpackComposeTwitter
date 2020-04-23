package com.sudo.rizwan.twitterclone.screens

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.core.tag
import androidx.ui.foundation.Border
import androidx.ui.foundation.Image
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.drawBorder
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.models.User
import com.sudo.rizwan.twitterclone.tweets
import com.sudo.rizwan.twitterclone.widgets.CustomDivider
import com.sudo.rizwan.twitterclone.widgets.TweetLayout

@Composable
fun Profile(user: User) {
    VerticalScroller {
        ConstraintLayout(constraintSet = ConstraintSet {
            val banner = tag("banner")
            val avatar = tag("avatar")
            val content = tag("content")
            avatar.top constrainTo banner.bottom
            avatar.bottom constrainTo banner.bottom
            avatar.left constrainTo parent.left
            avatar.left.margin = 16.dp
            content.top constrainTo banner.bottom
        }) {
            Image(
                imageResource(R.drawable.profile_banner),
                modifier = Modifier
                    .preferredHeight(180.dp)
                    .fillMaxWidth()
                    .tag("banner"),
                contentScale = ContentScale.Crop
            )
            Image(
                imageResource(user.avatar),
                modifier = Modifier
                    .preferredSize(80.dp)
                    .clip(shape = RoundedCornerShape(40.dp))
                    .tag("avatar")
                    .drawBorder(border = Border(size = 3.dp, color = Color.White), shape = RoundedCornerShape(40.dp)),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.tag("content")) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                    Spacer(modifier = Modifier.preferredHeight(44.dp))
                    UserInfo(user = user, showBio = true)
                    Spacer(modifier = Modifier.preferredHeight(16.dp))
                }
                CustomDivider()
                tweets.filter { it.user == user }.forEach { tweet ->
                    TweetLayout(tweet)
                    CustomDivider()
                }
            }
        }
    }
}