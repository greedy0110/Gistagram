package com.greedy0110.gistagram.view

import com.greedy0110.gistagram.entity.User

interface UserListView {
    // require update user list
    fun setUserList(userList: List<User>)
}