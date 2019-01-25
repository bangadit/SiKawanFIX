package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_nilai.*

class NilaiUAS : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nilai_uas)

        ic_back.setOnClickListener {
            val intent = Intent(this@NilaiUAS, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
