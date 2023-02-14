package com.example.retrofitsample.api

import com.example.retrofitsample.data.ResponseMessage
import com.example.retrofitsample.data.User
import com.example.retrofitsample.data.UserResponse
import retrofit2.Call
import retrofit2.http.*


interface ApiService {

    @GET("/users")
    fun getUsers(): Call<UserResponse>

    @GET("/users/{id}")
    fun getUserById(@Path("id") id:String): Call<User>

    @GET("/users")
    fun getUserBy(@Query("id") id:String): Call<User>

    @POST("/user")
    fun createUser(@Body user: User): Call<ResponseMessage>

    @DELETE("/delete")
    fun deleteUser(): Call<ResponseMessage>

    @GET("/users")
    fun getUsersWithHeader(@Header("token") token: String): Call<UserResponse>

    @GET("/users")
    fun getUsersWithHeaders(@HeaderMap headers: Map<String,String>): Call<UserResponse>

    @GET
    fun getUsersWithUrl(@Url url: String): Call<UserResponse>

    @FormUrlEncoded
    @POST("user/edit")
    fun updateUser(
        @Field("name") name: String?,
        @Field("surname") surname: String?
    ): Call<User>

}