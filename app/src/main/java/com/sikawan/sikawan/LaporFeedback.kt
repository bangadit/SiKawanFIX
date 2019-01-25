package com.sikawan.sikawan

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lapor_lanjutan.*

class LaporFeedback : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor_feedback)

        ic_back.setOnClickListener {
            finish()
        }
    }
}
