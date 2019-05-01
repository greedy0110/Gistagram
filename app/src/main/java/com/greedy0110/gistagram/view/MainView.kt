package com.greedy0110.gistagram.view

import com.greedy0110.gistagram.entity.User

interface MainView {
    // require user ui update
    fun setUserInfo(user: User)
}