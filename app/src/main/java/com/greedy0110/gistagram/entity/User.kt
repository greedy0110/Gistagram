package com.greedy0110.gistagram.entity

data class User(
    var name: String,
    var nickname: String,
    var url: String,
    var avatar_url: String = "",
    var blog: String = "",
    var location: String = "",
    var email: String = "",
    var bio: String = "",
    var followers: Int = 0,
    var following: Int = 0
)