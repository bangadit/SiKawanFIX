package com.sikawan.sikawan.lapor

import com.sikawan.sikawan.service.SiKawanService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LaporPresenter(private val service: SiKawanService, private val laporView: LaporView) {

    fun getAllLapor() {
        service.getLapor().enqueue(object : Callback<LaporRespone> {
            override fun onResponse(call: Call<LaporRespone>, response: Response<LaporRespone>) {
                if (response.code() == 200) {
                    response.body()?.result?.let {
                        laporView.onSuccessGetLapor(it.toMutableList())
                    }
                }
            }

            override fun onFailure(call: Call<LaporRespone>, t: Throwable) {

            }
        })
    }
}