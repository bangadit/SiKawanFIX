package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sikawan.sikawan.nilai.NilaiAdapter
import com.sikawan.sikawan.nilai.NilaiModel
import com.sikawan.sikawan.nilai.NilaiPresenter
import com.sikawan.sikawan.nilai.NilaiView
import com.sikawan.sikawan.profil.ProfilModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Response

class HomeActivity : AppCompatActivity(), NilaiView {

    private val listNilai = mutableListOf<NilaiModel>()
    private val adapterMain = NilaiAdapter(listNilai, this@HomeActivity)

    lateinit var nilaiPresenter: NilaiPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getUser()
        getNilai()

        nilaiPresenter = NilaiPresenter(MainApplication.service,this)
        nilaiPresenter.getAllNilai()

        crdLapor.setOnClickListener {
            val intent = Intent(this@HomeActivity, LaporActivity::class.java)
            startActivity(intent)
        }

        imgProfil.setOnClickListener {
            val intent = Intent(this@HomeActivity, ProfilActivity::class.java)
            startActivity(intent)
        }

        tvProfil.setOnClickListener {
            val intent = Intent(this@HomeActivity, ProfilActivity::class.java)
            startActivity(intent)
        }

        imgHome.setOnClickListener {
            val intent = Intent(this@HomeActivity, DaftarLaporanActivity::class.java)
            startActivity(intent)
        }

        tvDaftarLaporan.setOnClickListener {
            val intent = Intent(this@HomeActivity, DaftarLaporanActivity::class.java)
            startActivity(intent)
        }


    }

    fun getUser() {
        MainApplication.service.getProfil()
            .enqueue(object : retrofit2.Callback<ProfilModel> {
                override fun onFailure(call: Call<ProfilModel>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ProfilModel>?, response: Response<ProfilModel>?) {
                    val respone = response?.body()

                    tvName.text = respone?.nama_murid
                    tvSekolah.text = respone?.nama_sekolah
                    Picasso.get().load(respone?.avatar?.url).into(imgUser)
                }

            })
    }

    private fun getNilai() {
        with(rv_nilai) {
            adapter = adapterMain
            layoutManager = LinearLayoutManager(this@HomeActivity)
        }
    }

    override fun onSuccessGetNilai(data: MutableList<NilaiModel>) {
        listNilai.clear()
        listNilai.addAll(data)
        adapterMain.notifyDataSetChanged()
    }
}
