package com.sudo.rizwan.twitterclone.ui.home

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Dialog
import androidx.ui.foundation.Image
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.material.Button
import androidx.ui.material.RadioButton
import androidx.ui.material.Surface
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.darkThemeColors
import com.sudo.rizwan.twitterclone.darkerThemeColors
import com.sudo.rizwan.twitterclone.lightThemeColors
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.state.sudorizwan
import com.sudo.rizwan.twitterclone.ui.common.CustomDivider
import com.sudo.rizwan.twitterclone.ui.common.ThemedText
import com.sudo.rizwan.twitterclone.ui.common.UserInfo

@Composable
fun AppDrawer() {
    val showThemeDialog = state { false }
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
                SideBarListItem(
                    text = "Lists",
                    icon = R.drawable.ic_lists
                )
                SideBarListItem(
                    text = "Topics",
                    icon = R.drawable.ic_topics
                )
                SideBarListItem(
                    text = "Bookmarks",
                    icon = R.drawable.ic_bookmarks
                )
                SideBarListItem(
                    text = "Moments",
                    icon = R.drawable.ic_moments
                )
            }
            CustomDivider()
            Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp)) {
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(
                    text = "Settings and privacy",
                    style = TextStyle(fontSize = 18.sp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                ThemedText(
                    text = "Help Center",
                    style = TextStyle(fontSize = 18.sp)
                )
            }
            Spacer(modifier = Modifier.weight(weight = 1f))
            CustomDivider()
            Row(
                modifier = Modifier.fillMaxWidth()
                    .preferredHeight(40.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalGravity = Alignment.CenterVertically
            ) {
                Button(
                    padding = InnerPadding(all = 0.dp),
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp,
                    onClick = { showThemeDialog.value = true }) {
                    Image(
                        imageResource(R.drawable.ic_theme),
                        modifier = Modifier.preferredSize(30.dp)
                    )
                }
                Button(
                    padding = InnerPadding(all = 0.dp),
                    backgroundColor = Color.Transparent,
                    elevation = 0.dp,
                    onClick = {}) {
                    Image(
                        imageResource(R.drawable.ic_qrcode),
                        modifier = Modifier.preferredSize(30.dp)
                    )
                }
            }
        }
        if (showThemeDialog.value) {
            Dialog(onCloseRequest = { showThemeDialog.value = false }) {
                Surface(
                    modifier = Modifier.preferredWidth(300.dp),
                    shape = RoundedCornerShape(10.dp),
                    color = AppState.theme.surface
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        ThemedText(text = "Pick a theme", style = TextStyle(fontSize = 22.sp))
                        Spacer(modifier = Modifier.preferredHeight(16.dp))
                        ThemeOption("Light", AppState.theme == lightThemeColors) {
                            // on click
                            AppState.theme = lightThemeColors
                        }
                        ThemeOption("Dark", AppState.theme == darkThemeColors) {
                            // on click
                            AppState.theme = darkThemeColors
                        }
                        ThemeOption("Darker", AppState.theme == darkerThemeColors) {
                            // on click
                            AppState.theme = darkerThemeColors
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SideBarListItem(text: String, icon: Int) {
    Row(modifier = Modifier.preferredHeight(50.dp), verticalGravity = Alignment.CenterVertically) {
        Image(
            imageResource(icon),
            modifier = Modifier.preferredSize(24.dp)
        )
        Spacer(modifier = Modifier.preferredWidth(12.dp))
        ThemedText(
            text = text,
            style = TextStyle(fontSize = 18.sp)
        )
    }
}

@Composable
private fun ThemeOption(text: String, selected: Boolean, onSelect: () -> Unit) {
    Button(onClick = onSelect, backgroundColor = Color.Transparent, elevation = 0.dp) {
        Row(
            modifier = Modifier.preferredHeight(34.dp).fillMaxWidth(),
            verticalGravity = Alignment.CenterVertically
        ) {
            RadioButton(
                selected = selected,
                onSelect = onSelect,
                color = AppState.theme.primary
            )
            Spacer(modifier = Modifier.preferredWidth(16.dp))
            ThemedText(text = text)
        }
    }
}