package com.sudo.rizwan.twitterclone.screens

import androidx.compose.Composable
import androidx.compose.remember
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Clickable
import androidx.ui.foundation.Image
import androidx.ui.foundation.VerticalScroller
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.layout.*
import androidx.ui.material.*
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.darkThemeColors
import com.sudo.rizwan.twitterclone.models.User
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.sudorizwan
import com.sudo.rizwan.twitterclone.tweets
import com.sudo.rizwan.twitterclone.widgets.CustomDivider
import com.sudo.rizwan.twitterclone.widgets.ThemedText
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
            BottomAppBar(backgroundColor = AppState.theme.surface) {
                Row(
                    modifier = Modifier.weight(1f),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    BottomBarIcon(R.drawable.ic_home)
                    BottomBarIcon(R.drawable.ic_search)
                    BottomBarIcon(R.drawable.ic_notifications)
                    BottomBarIcon(R.drawable.ic_dm)
                }
            }
        }
    )
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

@Composable
fun AppDrawer() {
    Surface(color = AppState.theme.surface) {
        Column {
            Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
                Image(
                    imageResource(R.drawable.profile_image),
                    modifier = Modifier
                        .preferredSize(50.dp)
                        .clip(shape = RoundedCornerShape(25.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.preferredHeight(2.dp))
                UserInfo(sudorizwan)
                Spacer(modifier = Modifier.preferredHeight(16.dp))
            }
            CustomDivider()
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                SideBarListItem(text = "Lists", icon = R.drawable.ic_lists)
                SideBarListItem(text = "Topics", icon = R.drawable.ic_topics)
                SideBarListItem(text = "Bookmarks", icon = R.drawable.ic_bookmarks)
                SideBarListItem(text = "Moments", icon = R.drawable.ic_moments)
            }
            CustomDivider()
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(text = "Settings and privacy", style = TextStyle(fontSize = 18.sp))
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(text = "Help Center", style = TextStyle(fontSize = 18.sp))
            }
            Spacer(modifier = Modifier.weight(weight = 1f))
            CustomDivider()
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .preferredHeight(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalGravity = Alignment.CenterVertically
            ) {
                Clickable(onClick = {
                    AppState.theme = darkThemeColors
                }) {
                    Image(
                        imageResource(R.drawable.ic_theme),
                        modifier = Modifier.preferredSize(30.dp)
                    )
                }
                Image(
                    imageResource(R.drawable.ic_qrcode),
                    modifier = Modifier.preferredSize(30.dp)
                )
            }
        }
    }
}

@Composable
fun UserInfo(user: User, showBio: Boolean = false) {
    ThemedText(
        text = user.name,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
    )
    ThemedText(text = "@${user.username}")
    if (showBio) {
        Spacer(modifier = Modifier.preferredHeight(8.dp))
        ThemedText(text = user.bio, style = TextStyle(fontSize = 14.sp))
    }
    Spacer(modifier = Modifier.preferredHeight(8.dp))
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalGravity = Alignment.CenterVertically
    ) {
        ThemedText(
            text = "${user.following} ",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        ThemedText(text = "Following", style = TextStyle(fontSize = 14.sp))
        Spacer(modifier = Modifier.preferredWidth(24.dp))
        ThemedText(
            text = "${user.followers} ",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        ThemedText(text = "Followers", style = TextStyle(fontSize = 14.sp))
    }
}

@Composable
fun SideBarListItem(text: String, icon: Int) {
    Row(modifier = Modifier.preferredHeight(50.dp), verticalGravity = Alignment.CenterVertically) {
        Image(
            imageResource(icon),
            modifier = Modifier.preferredSize(40.dp)
        )
        Spacer(modifier = Modifier.preferredWidth(16.dp))
        ThemedText(text = text, style = TextStyle(fontSize = 18.sp))
    }
}

@Composable
fun TopBar(scaffoldState: ScaffoldState) {
    Surface(elevation = 2.dp, color = AppState.theme.surface) {
        Row(
            modifier = Modifier.preferredHeight(50.dp)
                .padding(start = 16.dp, end = 16.dp)
                .fillMaxWidth(),
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
