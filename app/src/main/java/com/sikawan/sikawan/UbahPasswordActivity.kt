package com.sikawan.sikawan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ubah_password.*

class UbahPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_password)

        btnSimpan.setOnClickListener {
            finish()
        }

        ic_back.setOnClickListener {
            finish()
        }

    }
}
