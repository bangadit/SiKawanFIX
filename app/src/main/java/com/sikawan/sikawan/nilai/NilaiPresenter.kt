package com.sikawan.sikawan.nilai

import com.sikawan.sikawan.service.SiKawanService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NilaiPresenter(private val service: SiKawanService, private val nilaiView: NilaiView) {

    fun getAllNilai() {
        service.getNilai().enqueue(object : Callback<NilaiRespone> {
            override fun onResponse(call: Call<NilaiRespone>, response: Response<NilaiRespone>) {
                if (response.code() == 200) {
                    response.body()?.result?.let {
                        nilaiView.onSuccessGetNilai(it.toMutableList())
                    }
                }
            }

            override fun onFailure(call: Call<NilaiRespone>, t: Throwable) {

            }
        })
    }
}