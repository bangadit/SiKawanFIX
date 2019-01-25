package com.sikawan.sikawan

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.sikawan.sikawan.profil.ProfilModel
import com.sikawan.sikawan.service.LoginRespone
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        getUser()
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
                    tvSekolah.text = respone?.sekolah_id
                    Picasso.get().load(respone?.avatar?.url).into(imgUser)
                }

            })
    }
}
