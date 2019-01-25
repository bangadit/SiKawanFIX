package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_tv3.*

class tv3 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tv3)

        ic_back.setOnClickListener {
            val intent = Intent(this@tv3, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
