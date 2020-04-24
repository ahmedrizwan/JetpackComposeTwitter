package com.sudo.rizwan.twitterclone.ui.common

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.models.Tweet
import com.sudo.rizwan.twitterclone.state.Screen
import com.sudo.rizwan.twitterclone.state.navigateTo

@Composable
fun TweetLayout(tweet: Tweet) {
    Row(modifier = Modifier.padding(all = 10.dp)) {
        Clickable(onClick = {
            navigateTo(Screen.Profile(tweet.user))
        }) {
            Image(
                imageResource(tweet.user.avatar),
                modifier = Modifier
                    .preferredSize(50.dp)
                    .clip(shape = RoundedCornerShape(25.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.preferredSize(12.dp))
        Column {
            Row(verticalGravity = Alignment.CenterVertically) {
                ThemedText(
                    text = tweet.user.name,
                    style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 16.sp)
                )
                Spacer(modifier = Modifier.preferredSize(5.dp))
                GrayText(text = "@${tweet.user.username} · ${tweet.timestamp}")
            }
            Spacer(modifier = Modifier.preferredSize(1.dp))
            ThemedText(
                text = tweet.tweet,
                style = TextStyle(fontSize = 14.sp)
            )
            if (tweet.image != null) {
                Image(
                    imageResource(tweet.image),
                    modifier = Modifier
                        .preferredHeight(180.dp)
                        .fillMaxWidth()
                        .clip(shape = RoundedCornerShape(10.dp))
                )
            }
            Spacer(modifier = Modifier.preferredSize(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth() + Modifier.padding(end = 40.dp),
                verticalGravity = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                val imageSize = 18.dp
                Row {
                    Image(
                        imageResource(R.drawable.ic_comment),
                        modifier = Modifier.preferredSize(imageSize)
                    )
                    Spacer(modifier = Modifier.preferredSize(4.dp))
                    GrayText(text = tweet.comments.toString())
                }

                Row {
                    Image(
                        imageResource(if (tweet.retweeted) R.drawable.ic_retweeted else R.drawable.ic_retweet),
                        modifier = Modifier.preferredSize(imageSize)
                    )
                    Spacer(modifier = Modifier.preferredSize(4.dp))
                    GrayText(text = tweet.retweets.toString())
                }


                Row {
                    Image(
                        imageResource(if (tweet.liked) R.drawable.ic_liked else R.drawable.ic_like),
                        modifier = Modifier.preferredSize(imageSize)
                    )
                    Spacer(modifier = Modifier.preferredSize(4.dp))
                    GrayText(text = tweet.likes.toString())
                }

                Image(
                    imageResource(R.drawable.ic_share),
                    modifier = Modifier.preferredSize(imageSize)
                )
            }
        }
    }
}
