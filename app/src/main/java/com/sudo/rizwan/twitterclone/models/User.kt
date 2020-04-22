package com.sudo.rizwan.twitterclone.models

data class User(
    val name: String,
    val username: String,
    val avatar: Int,
    val banner: String,
    val bio: String,
    val following: Int,
    val followers: Int,
    val verified: Boolean
)