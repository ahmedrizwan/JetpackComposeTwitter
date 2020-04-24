package com.sudo.rizwan.twitterclone.ui.common

import androidx.compose.Composable
import androidx.ui.core.Alignment
import androidx.ui.core.Modifier
import androidx.ui.layout.*
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.sudo.rizwan.twitterclone.models.User

@Composable
fun UserInfo(user: User, showBio: Boolean = false) {
    ThemedText(
        text = user.name,
        style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 18.sp)
    )
    ThemedText(text = "@${user.username}")
    if (showBio) {
        Spacer(modifier = Modifier.preferredHeight(8.dp))
        ThemedText(
            text = user.bio,
            style = TextStyle(fontSize = 14.sp)
        )
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
        ThemedText(
            text = "Following",
            style = TextStyle(fontSize = 14.sp)
        )
        Spacer(modifier = Modifier.preferredWidth(24.dp))
        ThemedText(
            text = "${user.followers} ",
            style = TextStyle(fontWeight = FontWeight.Bold)
        )
        ThemedText(
            text = "Followers",
            style = TextStyle(fontSize = 14.sp)
        )
    }
}