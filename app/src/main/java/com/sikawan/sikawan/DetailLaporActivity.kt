package com.sikawan.sikawan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sikawan.sikawan.lapor.DetailLaporRespon
import com.sikawan.sikawan.lapor.LaporModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_lapor.*
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailLaporActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_lapor)
        requestServices(intent.getIntExtra("id", 0))

        ic_back.setOnClickListener {
            finish()
        }
    }

    private fun requestServices(id: Int) {
        val call = MainApplication.service.searchLapor(id)
        call.enqueue(object : Callback<DetailLaporRespon>{
            override fun onResponse(call: Call<DetailLaporRespon>, response: Response<DetailLaporRespon>) {
                if (response.code() == 200) {
                    response.body()?.result?.let {
                        getData(it)
                    }
                }
            }

            override fun onFailure(call: Call<DetailLaporRespon>, t: Throwable) {

            }
        })
    }

    private fun getData(data: LaporModel?) {
        tvFasilitasSekolah.text = data?.judul
        tvIsi.text = data?.isi
        tvStatus.text = data?.status
        tvIsiBalasan.text = data?.balasan
        Picasso.get().load(data?.gambar).into(fotokelas)
    }
}
