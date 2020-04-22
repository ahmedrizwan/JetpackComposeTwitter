package com.sudo.rizwan.twitterclone.widgets

import androidx.compose.Composable
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.Text
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.models.Tweet

@Composable
fun TweetLayout(tweet: Tweet) {
    Row {
        Clickable(onClick = {
            // TODO: Open profile
        }) {
            Image(
                imageResource(tweet.user.avatar),
                modifier = Modifier
                    .preferredSize(50.dp)
                    .clip(shape = RoundedCornerShape(25.dp)),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.preferredWidth(12.dp))
        Column {
            Row {
                Text(text = tweet.user.name)
                Spacer(modifier = Modifier.preferredWidth(5.dp))
                Text(text = tweet.user.username)
                Spacer(modifier = Modifier.preferredWidth(5.dp))
                Text(text = ".")
                Spacer(modifier = Modifier.preferredWidth(5.dp))
                Text(text = tweet.timestamp.toString())
            }
            Spacer(modifier = Modifier.preferredWidth(4.dp))
            Text(text = tweet.tweet)
            Spacer(modifier = Modifier.preferredWidth(12.dp))
            Row {
                Image(
                    imageResource(R.drawable.comment),
                    modifier = Modifier.preferredSize(15.dp)
                )
                Spacer(modifier = Modifier.preferredWidth(8.dp))
                Text(text = tweet.comments.toString())
            }
        }
    }
}