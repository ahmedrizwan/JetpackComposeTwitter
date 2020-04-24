package com.sudo.rizwan.twitterclone.state

import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.models.Tweet
import com.sudo.rizwan.twitterclone.models.User

// Users
val sudorizwan = User(
    name = "Ahmed Rizwan",
    username = "sudo_rizwan",
    avatar = R.drawable.profile_image,
    banner = "https://pbs.twimg.com/profile_banners/968284418/1578616922/1500x500",
    bio = "Android Engineer @Snappymob",
    following = 248,
    followers = 343,
    verified = false
)

// Tweets
val tweets = listOf(
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        R.drawable.tweet_image,
        495,
        false,
        193,
        false,
        2,
        "2d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        null,
        495,
        false,
        193,
        true,
        2,
        "2d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        null,
        495,
        true,
        193,
        false,
        2,
        "2d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        null,
        495,
        false,
        193,
        false,
        2,
        "2d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        null,
        495,
        false,
        193,
        false,
        2,
        "2d"
    )
)
