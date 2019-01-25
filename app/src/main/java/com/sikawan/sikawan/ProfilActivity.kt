package com.sikawan.sikawan

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sikawan.sikawan.profil.ProfilModel
import kotlinx.android.synthetic.main.activity_profil.*
import retrofit2.Call
import retrofit2.Response

class ProfilActivity : AppCompatActivity() {
    lateinit var preference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)
        getUser()

        tvKeluarAkun.setOnClickListener {
            preference = getSharedPreferences("SiKawanLogin", Context.MODE_PRIVATE)
            preference.edit().clear().apply()
            val intent = Intent(this@ProfilActivity, LoginActivity::class.java)
            startActivity(intent)
            finishAffinity()
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

    fun getUser() {
        MainApplication.service.getProfil()
            .enqueue(object : retrofit2.Callback<ProfilModel> {
                override fun onFailure(call: Call<ProfilModel>?, t: Throwable?) {

                }

                override fun onResponse(call: Call<ProfilModel>?, response: Response<ProfilModel>?) {
                    val respone = response?.body()

                    tvName.text = respone?.nama_murid
                    tvNISN.text = respone?.username
                    tvSekolah.text = respone?.sekolah_id
                }

            })
    }
}
