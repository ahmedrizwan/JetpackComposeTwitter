package com.sudo.rizwan.twitterclone.models

data class Tweet(
    val user: User,
    val tweet: String,
    val image: String,
    val likes: Int,
    val retweets: Int,
    val comments: Int,
    val timestamp: Int,
    val retweeted: Boolean,
    val liked: Boolean
)