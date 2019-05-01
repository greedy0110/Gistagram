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

class GithubClient {
    private val BASE_URL = "https://api.github.com"

    object RepoDeserializer: JsonDeserializer<Repo> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): Repo {
            val jsonObject = json?.asJsonObject
            Log.d("seungmin repo", json?.toString())

            val name = jsonObject?.jsonNullSafeGet("name")?.asString
            val full_name = jsonObject?.jsonNullSafeGet("full_name")?.asString
            val url = jsonObject?.jsonNullSafeGet("html_url")?.asString
            val desc = jsonObject?.jsonNullSafeGet("description")?.asString

            return Repo(
                name = name?:"", full_name = full_name?:"",url = url?:"", description = desc?:""
            )
        }


    }

    object UserDeserializer: JsonDeserializer<User> {
        override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): User {
            val jsonObject = json?.asJsonObject
            Log.d("seungmin", "user : ${json.toString()}")

            val login = jsonObject?.jsonNullSafeGet("login")?.asString
            val name = jsonObject?.jsonNullSafeGet("name")?.asString
            val url = jsonObject?.jsonNullSafeGet("html_url")?.asString
            val avatar_url = jsonObject?.jsonNullSafeGet("avatar_url")?.asString
            val blog = jsonObject?.jsonNullSafeGet("blog")?.asString
            val location = jsonObject?.jsonNullSafeGet("location")?.asString
            val email = jsonObject?.jsonNullSafeGet("email")?.asString
            val bio = jsonObject?.jsonNullSafeGet("bio")?.asString
            val followers = jsonObject?.jsonNullSafeGet("followers")?.asInt
            val following = jsonObject?.jsonNullSafeGet("following")?.asInt

            return User(
                login = login?:"", name = name?:"", url = url?:"" ,avatar_url = avatar_url?:"" ,
                blog = blog?:"" , location = location?:"" , email = email?:"" , bio = bio?:"" ,
                following = following?:0 , followers = followers?:0
            )
        }
    }

    fun getApi(): GithubApi{
        val gson = GsonBuilder()
            .registerTypeAdapter(Repo::class.java, RepoDeserializer)
            .registerTypeAdapter(User::class.java, UserDeserializer)
            .create()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
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