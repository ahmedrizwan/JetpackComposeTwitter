package com.sudo.rizwan.twitterclone.models

import androidx.compose.Model
import java.util.*

@Model
data class Tweet(
    val user: User,
    val tweet: String,
    val image: Int?,
    var likes: Int,
    var liked: Boolean,
    var retweets: Int,
    var retweeted: Boolean,
    val comments: Int,
    val timestamp: Long
) {
    fun like() {
        this.liked = !this.liked
        this.likes = if (this.liked) this.likes + 1 else this.likes - 1
    }

    fun retweet() {
        this.retweeted = !this.retweeted
        this.retweets = if (this.retweeted) this.retweets + 1 else this.retweets - 1
    }


    fun timeAgo(): String {
        val currentTime = Date().time;
        val timeDiff = currentTime - timestamp;
        if (timeDiff >= (1000 * 60 * 60 * 24)) {
            // Days
            return "${timeDiff / (1000 * 60 * 60 * 24)}d";
        } else if (timeDiff >= (1000 * 60 * 60)) {
            // Hours
            return "${timeDiff / (1000 * 60 * 60)}h";
        } else if (timeDiff >= (1000 * 60)) {
            // Minutes
            return "${timeDiff / (1000 * 60)}m";
        } else if (timeDiff >= 1000) {
            // Seconds
            return "${timeDiff / 1000}s";
        }
        return "0s";
    }
}
