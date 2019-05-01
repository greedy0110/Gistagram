package com.greedy0110.gistagram.data.source

import com.greedy0110.gistagram.data.GithubDataSource
import com.greedy0110.gistagram.entity.Repo
import com.greedy0110.gistagram.entity.User

/*
* demo data
* */
class GithubDemoSource(): GithubDataSource {
    override fun getCurrentUser(): User {
        return cat
    }

    override fun getRepoList(user: User): List<Repo> {
        return listOf(a2f, pm)
    }

    override fun getFollowersList(user: User): List<User> {
        return listOf(greedy, cat, han)
    }

    override fun getFollowingList(user: User): List<User> {
        return listOf(cat, han)
    }

    val greedy = User(
        name = "seungmin shin",
        nickname = "greedy0110",
        url = "https://github.com/users/greedy0110",
        avatar_url = "https://avatars3.githubusercontent.com/u/16049092?v=4",
        blog = "http://greedy0110.tistory.com/",
        bio = "developer, interested in Android (Kotlin)",
        followers = 6,
        following = 8
    )

    val cat = User(
        name = "catSirup",
        nickname = "catSirup",
        url = "https://github.com/users/catSirup",
        avatar_url = "https://avatars2.githubusercontent.com/u/19964567?v=4",
        blog = "https://catsirup.github.io",
        bio = "파이썬과 딥러닝을 공부하고 있습니다.",
        followers = 5,
        following = 6
    )

    val han = User(
        name = "HanJungwoo1102",
        nickname = "Han",
        url = "https://github.com/users/HanJungwoo1102",
        avatar_url = "https://avatars1.githubusercontent.com/u/38420556?v=4",
        blog = "https://hanjungwoo1102.github.io/",
        bio = "Hi",
        followers = 3,
        following = 6
    )

    val a2f = Repo(
        name = "Activity2Fragment",
        full_name = "greedy0110/Activity2Fragment",
        description = "Activity 와 Fragment 사이 데이터 교환을 위해 ViewModel + LiveData 를 사용한 기본적인 구현",
        url = "https://github.com/greedy0110/Activity2Fragment"
    )

    val pm = Repo(
        name = "ProjectM",
        full_name = "greedy0110/ProjectM",
        description = "피하지 못하면 풀어라. kotlin",
        url = "https://github.com/greedy0110/ProjectM"
    )
}