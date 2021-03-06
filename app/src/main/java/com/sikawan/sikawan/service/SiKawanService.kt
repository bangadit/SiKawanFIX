package com.sikawan.sikawan.service

import com.sikawan.sikawan.DetailLaporActivity
import com.sikawan.sikawan.lapor.DetailLaporRespon
import com.sikawan.sikawan.lapor.LaporModel
import com.sikawan.sikawan.lapor.LaporRespone
import com.sikawan.sikawan.nilai.NilaiRespone
import com.sikawan.sikawan.profil.ProfilModel
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

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

    @GET("public/api/v1/get-my-profile")
    fun getProfil(): Call<ProfilModel>

    @GET("public/api/v1/cek-lapor")
    fun getLapor(): Call<LaporRespone>



    @GET("public/api/v1/get-nilai-user")
    fun getNilai(): Call<NilaiRespone>

    @GET("public/api/v1/get-lapor-detail/{id}")
    fun searchLapor(@Path("id") id: Int): Call<DetailLaporRespon>

//    @GET("public/api/v1/get-my-profile")
//    fun getAllPost() : Call<List<Post>
}