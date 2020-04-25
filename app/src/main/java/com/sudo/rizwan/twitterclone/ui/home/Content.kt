package com.sudo.rizwan.twitterclone.ui.home

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.VerticalScroller
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.ScaffoldState
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.state.tweets
import com.sudo.rizwan.twitterclone.ui.common.CustomDivider
import com.sudo.rizwan.twitterclone.ui.common.TweetLayout

@Composable
fun Content(scaffoldState: ScaffoldState) {
    Column(modifier = Modifier.padding(bottom = 54.dp)) {
        TopBar(scaffoldState = scaffoldState)
        VerticalScroller {
            Column {
                tweets.forEach { tweet ->
                    TweetLayout(tweet)
                    CustomDivider()
                }
            }
        }
    }
}

