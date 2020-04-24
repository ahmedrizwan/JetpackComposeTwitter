package com.sudo.rizwan.twitterclone.ui.profile

import androidx.compose.Composable
import androidx.ui.core.*
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.ui.common.UserInfo
import com.sudo.rizwan.twitterclone.models.User
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.state.tweets
import com.sudo.rizwan.twitterclone.ui.common.CustomDivider
import com.sudo.rizwan.twitterclone.ui.common.TweetLayout

@Composable
fun Profile(user: User) {
    val scrollerPosition = ScrollerPosition()
    VerticalScroller(scrollerPosition = scrollerPosition) {
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
            Row(
                modifier = Modifier.preferredHeight(54.dp).fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalGravity = Alignment.CenterVertically
            ) {
                Image(
                    imageResource(R.drawable.ic_dm),
                    modifier = Modifier
                        .preferredHeight(30.dp)
                )
                Image(
                    imageResource(R.drawable.ic_notifications),
                    modifier = Modifier
                        .preferredHeight(30.dp)
                )
            }
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
                    .drawBorder(
                        border = Border(size = 3.dp, color = AppState.theme.surface),
                        shape = RoundedCornerShape(40.dp)
                    ),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.tag("content")) {
                Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                    Spacer(modifier = Modifier.preferredHeight(44.dp))
                    UserInfo(
                        user = user,
                        showBio = true
                    )
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
