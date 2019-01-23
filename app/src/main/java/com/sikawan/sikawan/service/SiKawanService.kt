package com.sikawan.sikawan.service

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface SiKawanService {
    //path untuk base URL

    //@GET("/pos")
    //fun getAllPost() : Call<List<Post>>

    //@GET("/posts/{postId}")
    //fun getDetailPost(@Path("postId") postId: Int) : Call<Post>

    //@GET("/users/{userId}")
    //fun getDetailUser(@Path("userId") userId: Int) : Call<User>

    @POST("public/api/v1/auth/login")
    fun postLogin(@Body body: RequestBody): Call<LoginRespone>

//    @GET("public/api/v1/get-my-profile")
//    fun getAllPost() : Call<List<Post>>
}