package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lapor.*

class LaporActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor)

        ic_back.setOnClickListener {
            finish()
        }

        btnLaporkanKeluhan.setOnClickListener {
            val intent = Intent(this@LaporActivity, LaporLanjutanActivity::class.java)
            startActivity(intent)
        }
    }
}
