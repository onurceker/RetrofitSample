package com.example.retrofitsample.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitApi private constructor(){

    companion object{
        private var instance: Retrofit? = null
        private const val BASE_URL = "https://demo9270183.mockable.io/"

        private val okHttpClient =  OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }).build()

        @Synchronized
        fun getInstance(): Retrofit{

            if (instance == null){
                instance = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build()
            }

            return instance!!
        }
    }


}