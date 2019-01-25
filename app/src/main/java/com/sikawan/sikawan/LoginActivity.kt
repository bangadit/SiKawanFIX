package com.sikawan.sikawan

import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.sikawan.sikawan.service.LoginRespone
import com.sikawan.sikawan.service.SiKawanService
import kotlinx.android.synthetic.main.activity_login.*
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.Response

class LoginActivity : AppCompatActivity() {

    lateinit var preference: SharedPreferences
    val pref_show = "SiKawanLogin"
    val pref_token = "GetData"

    lateinit var activity: Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnMasuk.setOnClickListener {
            login()
        }

        activity = this
        preference = getSharedPreferences("SiKawanLogin", Context.MODE_PRIVATE)
        if (!preference.getBoolean(pref_show, true)) {
            startActivity(Intent(activity, HomeActivity::class.java))
            finish()
        }
    }


    fun masuk(token: String) {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        val editor = preference.edit()
        editor.putBoolean(pref_show, false)
        editor.putString(pref_token, token)
        editor.apply()
        finish()
    }

    fun login() {
        val mDialog = ProgressDialog(this@LoginActivity)
        mDialog.setMessage("Please waiting...")
        mDialog.show()

        val username = edtNISN.text.toString()
        val password = edtPassword.text.toString()
        val requestBody = MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("username", username)
                .addFormDataPart("password", password)
                .build()

        MainApplication.service.postLogin(requestBody)
                .enqueue(object : retrofit2.Callback<LoginRespone> {
                    override fun onFailure(call: Call<LoginRespone>?, t: Throwable?) {
                        val dialog = AlertDialog.Builder(this@LoginActivity)
                        val dialogView = layoutInflater.inflate(R.layout.activity_alert_service, null)
                        dialog.setView(dialogView)
                        val buttonFinish = dialogView.findViewById<Button>(R.id.btnCoba)
                        val dialogShow = dialog.show()

                        buttonFinish.setOnClickListener {
                            dialogShow.dismiss()
                        }
                        mDialog.dismiss()
                    }

                    override fun onResponse(call: Call<LoginRespone>?, response: Response<LoginRespone>?) {
                        val loginRespone = response?.body()

                        if (loginRespone?.message == "Login Successful") {
                            masuk(loginRespone.access_token)
                            mDialog.dismiss()
                        } else {
                            val dialog = AlertDialog.Builder(this@LoginActivity)
                            val dialogView = layoutInflater.inflate(R.layout.activity_alert, null)
                            dialog.setView(dialogView)
                            val buttonFinish = dialogView.findViewById<Button>(R.id.btnCoba)
                            val dialogShow = dialog.show()

                            buttonFinish.setOnClickListener {
                                dialogShow.dismiss()
                            }
                            mDialog.dismiss()
                        }

                    }

                })

    }
}
