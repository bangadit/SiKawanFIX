package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_presensi.*

class Presensi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_presensi)

        ic_back.setOnClickListener {
            finish()
        }

        tv3.setOnClickListener {
            val intent = Intent(this@Presensi, com.sikawan.sikawan.tv3::class.java)
            startActivity(intent)
        }
    }
}
