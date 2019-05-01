Gistagram
---------
Make github friends easliy
=========

## Purpose

When I'm meeting someone, I wanted to follow he's github account but It was too annoying so, I just gave up to follow him.
finally, I have few friends but I want to many friends in my github account, so I think this project :)

## Main Feature

1. Github Login / Logout
2. View he's(she's) Following / Followers
3. View he's(she's) repository list
4. Make Following esaliy and F4F also esaliy

## Data Type

1. User
    - name: String
    - nickname: String
    - url: String
    - avatar_url: String
    - blog: String
    - location: String
    - email: String
    - bio: String
    - followers: Int
    - following: Int
2. Repo
    - name: String
    - full_name: String
    - description: String
    - url: String

## Structure (MVP)

### Domain Layer
- entity
    - user
    - repo
- usecase (~~data layer의 기능과 중복되는거 아니야?~~)
    - login(yet)
    - logout(yet)
    - followUser(user)
    - unfollowUser(user)
    - getRepoList(user)
    - getFollowingList(user)
    - getFollowersList(user)

### Data Layer
- source (entity의 요소로 반환해야만 한다)
    - memory (샘플 데이터를 이용해서 앱이 정상적으로 작동하는지 확인함)
    - remote (restful api를 사용해서 데이터를 가져옴 -> *retrofit 사용할 것*)
        - remote model
        - remote mapper
- repository(source) (소스의 데이터를 가져오는 것, 수정하는 것)
    - GithubRepository
        - getRepoList(user)
        - getFollowingList(user)
        - getFollowersList(user)

### App Layer (View + Presenter)