package com.sikawan.sikawan

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_lapor_lanjutan.*

class LaporLanjutanActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lapor_lanjutan)

        btnLaporkanKeluhanLanjut.setOnClickListener {
            val intent = Intent(this@LaporLanjutanActivity, LaporFeedback::class.java)
            startActivity(intent)
        }

    }

    fun back(view: View) {
        finish()
    }


}
