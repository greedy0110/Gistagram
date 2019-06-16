package com.greedy0110.gistagram.data.remote

import android.util.Log
import com.google.gson.*
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User
import com.greedy0110.gistagram.ext.nullCheck
import com.greedy0110.gistagram.ext.jsonNullSafeGet
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.lang.reflect.Type

// TODO remote 코드를 분리하자.
class GithubClient {
    private val BASE_URL = "https://api.github.com"

    fun getApi(): GithubApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(GithubApi::class.java)
    }
}

interface GithubApi {
    @GET("users/{user}/repos")
    fun getRepos(@Path("user") user: String): Single<List<Repo>>

    @GET("users/{user}/followers")
    fun getFollowers(@Path("user") user: String): Single<List<User>>

    @GET("users/{user}/following")
    fun getFollowing(@Path("user") user: String): Single<List<User>>

    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Single<User>
}