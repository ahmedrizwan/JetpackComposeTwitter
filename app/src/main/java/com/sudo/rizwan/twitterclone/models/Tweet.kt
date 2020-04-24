package com.sudo.rizwan.twitterclone.models

import androidx.compose.Model

@Model
data class Tweet(
    val user: User,
    val tweet: String,
    val image: Int?,
    val likes: Int,
    var liked: Boolean,
    val retweets: Int,
    var retweeted: Boolean,
    val comments: Int,
    val timestamp: String
) {
    fun like() {
        this.liked = !this.liked
    }

    fun retweet() {
       this.retweeted = !this.retweeted
    }
}
