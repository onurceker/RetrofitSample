package com.example.retrofitsample.data


import com.google.gson.annotations.SerializedName

data class ResponseMessage(
    @SerializedName("msg")
    val msg: String
)