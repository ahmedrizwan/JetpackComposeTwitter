package com.sudo.rizwan.twitterclone.state

import com.sudo.rizwan.twitterclone.R
import com.sudo.rizwan.twitterclone.models.Tweet
import com.sudo.rizwan.twitterclone.models.User
import java.util.*

// Users
val sudorizwan = User(
    name = "Ahmed Rizwan",
    username = "sudo_rizwan",
    avatar = R.drawable.profile_image,
    banner = R.drawable.profile_banner,
    bio = "Android Engineer @Snappymob",
    following = 393,
    followers = 339,
    verified = false
)

val androiddevs = User(
    name = "Android Developers",
    username = "AndroidDev",
    avatar = R.drawable.android_dev_profile_image,
    banner = R.drawable.android_dev_profile_banner,
    bio = "News and announcements for developers from the Android team",
    following = 284,
    followers = 1000,
    verified = true
)

// Tweets
val tweets = mutableListOf(
    Tweet(
        sudorizwan,
        "This is a test tweet!",
        null,
        495,
        false,
        193,
        false,
        2,
        1587345183868
    ),
    Tweet(
        androiddevs,
        "Kickstart your Kotlin training!\n" +
                "\n" +
                "If you're a #Kotlin newbie, start with our Kotlin Bootcamp for programmers and Android Kotlin Fundamentals courses to learn the basics.",
        R.drawable.android_dev_tweet_image,
        495,
        true,
        193,
        true,
        2,
        1585852320000
    ),
    Tweet(
        sudorizwan,
        "Another test tweet, but with an image!",
        R.drawable.tweet_image,
        495,
        false,
        193,
        false,
        2,
        1587345183868
    ),
    Tweet(
        sudorizwan,
        "Test tweet 2",
        null,
        495,
        false,
        193,
        false,
        2,
        1585427520000
    ),
    Tweet(
        sudorizwan,
        "Test tweet 3",
        null,
        495,
        false,
        193,
        false,
        2,
        1585427520000
    ),
    Tweet(
        androiddevs,
        "Android Devs test tweet 1",
        null,
        495,
        false,
        193,
        true,
        2,
        1585852320000
    ),
    Tweet(
        androiddevs,
        "Android Devs test tweet 2",
        null,
        495,
        false,
        193,
        true,
        2,
        1585852320000
    )
)

fun createNewTweet(text: String) {
    tweets.add(
        0,
        Tweet(
            user = sudorizwan,
            tweet = text,
            likes = 0,
            liked = false,
            retweeted = false,
            retweets = 0,
            image = null,
            comments = 0,
            timestamp = Date().time
        )
    )
}