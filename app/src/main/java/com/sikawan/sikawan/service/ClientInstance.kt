package com.sikawan.sikawan.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClientInstance {
    companion object {
        private const val BASE_URL = "http://binar-perjuangan.herokuapp.com"

        val retrofit: Retrofit by lazy {
            return@lazy Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}