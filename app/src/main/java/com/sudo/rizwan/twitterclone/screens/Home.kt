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
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.unit.dp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.tweets
import com.sudo.rizwan.twitterclone.widgets.CustomDivider
import com.sudo.rizwan.twitterclone.widgets.TweetLayout

@Composable
fun Home(scaffoldState: ScaffoldState = remember { ScaffoldState() }) {
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer()
        },
        bodyContent = { modifier ->
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
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {}, backgroundColor = AppState.theme.primary) {
                Image(
                    imageResource(R.drawable.ic_compose),
                    modifier = Modifier
                        .preferredSize(25.dp)
                )
            }
        },
        bottomAppBar = {
            BottomAppBar(backgroundColor = Color.White) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    IconButton(onClick = {}) {
                        Image(
                            imageResource(R.drawable.ic_home),
                            modifier = Modifier
                                .preferredSize(24.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Image(
                            imageResource(R.drawable.ic_search),
                            modifier = Modifier
                                .preferredSize(24.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Image(
                            imageResource(R.drawable.ic_notifications),
                            modifier = Modifier
                                .preferredSize(24.dp)
                        )
                    }
                    IconButton(onClick = {}) {
                        Image(
                            imageResource(R.drawable.ic_dm),
                            modifier = Modifier
                                .preferredSize(24.dp)
                        )
                    }
                }
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
    Surface(elevation = 2.dp) {
        Row(
            modifier = Modifier.preferredHeight(50.dp)
                    + Modifier.padding(start = 16.dp, end = 16.dp)
                    + Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalGravity = Alignment.CenterVertically
        ) {
            Clickable(onClick = {
                scaffoldState.drawerState = DrawerState.Opened
            }) {
                Image(
                    imageResource(R.drawable.profile_image),
                    modifier = Modifier
                        .preferredSize(34.dp)
                        .clip(shape = RoundedCornerShape(17.dp)),
                    contentScale = ContentScale.Crop
                )
            }
            Image(
                imageResource(R.drawable.ic_twitter),
                modifier = Modifier
                    .preferredSize(22.dp)
            )
            Image(
                imageResource(R.drawable.ic_trends),
                modifier = Modifier
                    .preferredSize(24.dp)
            )
        }
    }
}
