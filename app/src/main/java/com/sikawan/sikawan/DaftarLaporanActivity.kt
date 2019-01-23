package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*

class DaftarLaporanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daftar_laporan)

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
}
