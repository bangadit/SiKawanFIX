package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.sikawan.sikawan.lapor.LaporAdapter
import com.sikawan.sikawan.lapor.LaporModel
import com.sikawan.sikawan.lapor.LaporPresenter
import com.sikawan.sikawan.lapor.LaporView
import kotlinx.android.synthetic.main.activity_daftar_laporan.*

class DaftarLaporanActivity : AppCompatActivity(),LaporView {
    private val listLapor = mutableListOf<LaporModel>()
    private val adapterMain = LaporAdapter(listLapor, this@DaftarLaporanActivity)

    lateinit var laporPresenter: LaporPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_laporan)
        getLapor()
        laporPresenter = LaporPresenter(MainApplication.service,this)
        laporPresenter.getAllLapor()

        btnHome.setOnClickListener {
            val intent = Intent(this@DaftarLaporanActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        tvHome.setOnClickListener {
            val intent = Intent(this@DaftarLaporanActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        imgProfil.setOnClickListener {
            val intent = Intent(this@DaftarLaporanActivity, ProfilActivity::class.java)
            startActivity(intent)
        }

        tvProfil.setOnClickListener {
            val intent = Intent(this@DaftarLaporanActivity, ProfilActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getLapor() {
        with(rv_lapor) {
            adapter = adapterMain
            layoutManager = LinearLayoutManager(this@DaftarLaporanActivity)
        }
    }

    override fun onSuccessGetLapor(data: MutableList<LaporModel>) {
        listLapor.clear()
        listLapor.addAll(data)
        adapterMain.notifyDataSetChanged()
    }
}
