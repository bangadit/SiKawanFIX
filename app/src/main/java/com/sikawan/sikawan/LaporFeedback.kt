package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lapor_feedback.*

class LaporFeedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor_feedback)

        btnKembali.setOnClickListener {
            val intent = Intent(this@LaporFeedback, DaftarLaporanActivity::class.java)
            startActivity(intent)
        }
    }
}
