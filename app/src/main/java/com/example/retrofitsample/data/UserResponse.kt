package com.example.retrofitsample.data

data class UserResponse(
    val users: List<User>
)

data class User(
    val id: Int,
    val name: String,
    val surname: String,
    val birthday: String,
    val image: String
)