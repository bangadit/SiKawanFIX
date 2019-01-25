package com.sikawan.sikawan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alert.*

class AlertServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_service)

        btnCoba.setOnClickListener {
            this@AlertServiceActivity
        }
    }
}
