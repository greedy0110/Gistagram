package com.greedy0110.gistagram.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.greedy0110.gistagram.R
import com.greedy0110.gistagram.adapter.UserDetailViewPagerAdapter
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainView {

    private val presenter: MainPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.bind(this)
        presenter.onCreate()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbind()
    }

    override fun setUserInfo(user: User) {
        Log.d("seungmin" , "first user : $user")

        Glide.with(this)
            .load(user.avatar_url)
            .into(img_main_userinfo_avatar)
        txt_main_userinfo_name.text = user.name
        txt_main_userinfo_nickname.text = user.login
        txt_main_userinfo_bio.text = user.bio

        // TODO draw fragment matched user
        vp_main_userdetail.adapter = UserDetailViewPagerAdapter(supportFragmentManager, user)
        tl_main_userdetail.setupWithViewPager(vp_main_userdetail)
    }
}
