package com.sudo.rizwan.twitterclone.ui.compose

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.state
import androidx.ui.core.Alignment
import androidx.ui.core.ContentScale
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.*
import androidx.ui.foundation.shape.corner.RoundedCornerShape
import androidx.ui.graphics.Color
import androidx.ui.input.KeyboardType
import androidx.ui.layout.*
import androidx.ui.layout.ColumnScope.weight
import androidx.ui.material.Button
import androidx.ui.material.IconButton
import androidx.ui.material.icons.Icons
import androidx.ui.material.icons.filled.Clear
import androidx.ui.res.imageResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp
import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.state.AppState
import com.sudo.rizwan.twitterclone.state.Screen
import com.sudo.rizwan.twitterclone.state.createNewTweet
import com.sudo.rizwan.twitterclone.state.navigateTo

@Composable
fun ComposeTweet() {
    val tweetText = state { TextFieldValue(text = "") }
    Column(modifier = Modifier.fillMaxHeight()) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 10.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalGravity = Alignment.CenterVertically
        ) {
            CloseButton()
            TweetButton(tweetText)
        }
        AvatarWithTextField(tweetText)
    }
}

@Composable
private fun AvatarWithTextField(tweetText: MutableState<TextFieldValue>) {
    Row(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 10.dp)
    ) {
        Image(
            imageResource(R.drawable.profile_image),
            modifier = Modifier
                .preferredSize(34.dp)
                .clip(shape = RoundedCornerShape(17.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.preferredWidth(10.dp))
        TextFieldWithHint(
            modifier = Modifier.fillMaxWidth(),
            value = tweetText.value,
            onValueChange = { textFieldValue -> tweetText.value = textFieldValue },
            hint = "What's happening?"
        )
    }
}

@Composable
private fun CloseButton() {
    IconButton(onClick = { navigateTo(Screen.Home) }) {
        Icon(
            modifier = Modifier.size(50.dp),
            asset = Icons.Filled.Clear,
            tint = AppState.theme.primary
        )
    }
}

@Composable
private fun TweetButton(tweetText: MutableState<TextFieldValue>) {
    Button(
        onClick = {
            createNewTweet(tweetText.value.text)
            navigateTo(Screen.Home)
        },
        shape = RoundedCornerShape(20.dp),
        backgroundColor = if (tweetText.value.text.isEmpty()) Color(0xFFAAAAAA) else AppState.theme.primary
    ) {
        Text(text = "Tweet", color = Color.White)
    }
}

@Composable
private fun TextFieldWithHint(
    value: TextFieldValue,
    modifier: Modifier,
    hint: String,
    onValueChange: (TextFieldValue) -> Unit
) {
    Stack(Modifier.weight(1f)) {
        TextField(
            value = value,
            modifier = modifier,
            onValueChange = onValueChange,
            keyboardType = KeyboardType.Text
        )
        if (value.text.isEmpty()) Text(
            text = hint,
            style = TextStyle(color = Color(0xFF666666), fontSize = 18.sp)
        )
    }
}
