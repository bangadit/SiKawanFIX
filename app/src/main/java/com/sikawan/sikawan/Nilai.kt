package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nilai.*

class Nilai : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai)

        cvUas.setOnClickListener {
            val intent = Intent(this@Nilai, NilaiUAS::class.java)
            startActivity(intent)
        }

        ic_back.setOnClickListener {
            finish()
        }
    }
}
