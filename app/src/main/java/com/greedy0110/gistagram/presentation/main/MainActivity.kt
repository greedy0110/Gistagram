package com.greedy0110.gistagram.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.adapter.UserDetailViewPagerAdapter
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presentation.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    // *where is the best place, viewModel place in? presenter? but viewModel has android dependency, view? but viewModel has it's own data.*
    // so i will take mvvm pattern!
    private val userViewModel: UserViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel.user.subscribe {
            setUserInfo(it)
        }
    }

    private fun setUserInfo(user: User) {
        Glide.with(this)
            .load(user.avatar_url)
            .into(img_main_userinfo_avatar)
        txt_main_userinfo_name.text = user.name
        txt_main_userinfo_nickname.text = user.login
        txt_main_userinfo_bio.text = user.bio

        // draw fragment matched user
        vp_main_userdetail.adapter = UserDetailViewPagerAdapter(supportFragmentManager, user)
        tl_main_userdetail.setupWithViewPager(vp_main_userdetail)
    }
}
