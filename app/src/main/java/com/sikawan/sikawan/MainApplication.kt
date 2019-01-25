package com.sikawan.sikawan

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.sikawan.sikawan.service.SiKawanService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class MainApplication : Application() {
    companion object {
        private const val BASE_URL = "http://binar-perjuangan.herokuapp.com"
        lateinit var preference: SharedPreferences
        lateinit var service: SiKawanService
        val pref_token = "GetData"
    }

    override fun onCreate() {
        super.onCreate()
        val client = OkHttpClient().newBuilder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()

        val retrofit: Retrofit by lazy {
            return@lazy Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .client(headerInterceptor())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        service = retrofit.create(SiKawanService::class.java)
    }
    private fun headerInterceptor(): OkHttpClient {
        preference = getSharedPreferences("SiKawanLogin", Context.MODE_PRIVATE)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor { chain ->
            val original = chain.request()

            // Request customization: add request headers
            val requestBuilder = original.newBuilder()
                    .header("Authorization", preference.getString(pref_token,"").toString()) // <-- this is the important line

            val request = requestBuilder.build()
            chain.proceed(request)
        }
        return httpClient.build()
    }

}