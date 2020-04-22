package com.sudo.rizwan.twitterclone

import com.sudo.rizwan.twitterclone.models.Tweet
import com.sudo.rizwan.twitterclone.models.User

// Users
val sudorizwan = User(
    "Ahmed Rizwan",
    "sudo_rizwan",
    R.drawable.profile_image,
    "https://pbs.twimg.com/profile_banners/968284418/1578616922/1500x500",
    "Android Engineer @Snappymob",
    248,
    343,
    false
)

val flutterDev = User(
    "Flutter",
    "FlutterDev",
    R.drawable.profile_image,
    "https://pbs.twimg.com/profile_banners/420730316/1578350457/1500x500",
    "Google’s UI toolkit to build apps for mobile, web, & desktop from a single codebase //",
    35,
    88675,
    true
)

// Tweets
val tweets = listOf(
    Tweet(
        flutterDev,
        """
        #FlutterFriday\nis\nhere.\n\nRight pointing backhand indexYou can specify whether your Flutter 
        project uses Swift, Objective C, Kotlin, or Java by specifying:\n\n"--ios-language objc" or "--android-langu
        age java" when you type "flutter create".\n\nElectric light bulbBy default new projects use Kotlin and 
        Swift. 
        """.trimIndent(),
        -1,
        15,
        false,
        38,
        false,
        244,
        "1d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        R.drawable.profile_image,
        495,
        false,
        193,
        false,
        2,
        "2d"
    ),
    Tweet(
        flutterDev,
        """
        #FlutterFriday\nis\nhere.\n\nRight pointing backhand indexYou can specify whether your Flutter 
        project uses Swift, Objective C, Kotlin, or Java by specifying:\n\n"--ios-language objc" or "--android-langu
        age java" when you type "flutter create".\n\nElectric light bulbBy default new projects use Kotlin and 
        Swift. 
        """.trimIndent(),
        -1,
        15,
        false,
        38,
        false,
        244,
        "1d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        R.drawable.profile_image,
        495,
        false,
        193,
        false,
        2,
        "2d"
    ),
    Tweet(
        flutterDev,
        """
        #FlutterFriday\nis\nhere.\n\nRight pointing backhand indexYou can specify whether your Flutter 
        project uses Swift, Objective C, Kotlin, or Java by specifying:\n\n"--ios-language objc" or "--android-langu
        age java" when you type "flutter create".\n\nElectric light bulbBy default new projects use Kotlin and 
        Swift. 
        """.trimIndent(),
        -1,
        15,
        false,
        38,
        false,
        244,
        "1d"
    ),
    Tweet(
        sudorizwan,
        "This is a test twt to see how all this works, yay!",
        R.drawable.profile_image,
        495,
        false,
        193,
        false,
        2,
        "2d"
    )
)
