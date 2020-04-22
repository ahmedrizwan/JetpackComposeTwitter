package com.sudo.rizwan.twitterclone.models

data class Tweet(
    val user: User,
    val tweet: String,
    val image: Int,
    val likes: Int,
    val liked: Boolean,
    val retweets: Int,
    val retweeted: Boolean,
    val comments: Int,
    val timestamp: String
)