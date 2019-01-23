package com.sikawan.sikawan

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        tvKeluarAkun.setOnClickListener {
            val intent = Intent(this@ProfilActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        tvUbahPassword.setOnClickListener {
            val intent = Intent(this@ProfilActivity, UbahPasswordActivity::class.java)
            startActivity(intent)
        }

        btnHome.setOnClickListener {
            val intent = Intent(this@ProfilActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        tvHome.setOnClickListener {
            val intent = Intent(this@ProfilActivity, HomeActivity::class.java)
            startActivity(intent)
        }

        imgHome.setOnClickListener {
            val intent = Intent(this@ProfilActivity, DaftarLaporanActivity::class.java)
            startActivity(intent)
        }

        tvDaftarLaporan.setOnClickListener {
            val intent = Intent(this@ProfilActivity, DaftarLaporanActivity::class.java)
            startActivity(intent)
        }
    }
}
