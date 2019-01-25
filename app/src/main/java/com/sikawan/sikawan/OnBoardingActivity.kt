package com.sikawan.sikawan

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewPager
import com.sikawan.sikawan.fragments.OnBoardingFragment
import kotlinx.android.synthetic.main.activity_on_boarding.*

class OnBoardingActivity : AppCompatActivity() {

    val fragment1 = OnBoardingFragment()
    val fragment2 = OnBoardingFragment()
    val fragment3 = OnBoardingFragment()
    lateinit var adapter: myPagerAdapter
    lateinit var activity: Activity

    lateinit var preference: SharedPreferences
    val pref_show = "SiKawan"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        activity = this
        preference = getSharedPreferences("SiKawan", Context.MODE_PRIVATE)
        if (!preference.getBoolean(pref_show, true)) {
            startActivity(Intent(activity, LoginActivity::class.java))
            finish()
        }
        fragment1.setTitle("SiKawan")
        fragment2.setTitle("Pantau Perkembangan Akademik")
        fragment3.setTitle("Lapor Keluhan")

        fragment1.setMembantu("Membantu orang tua siswa, guru, dan Dinas Pendidikan bersama-sama dalam mengawal pendidikan")
        fragment2.setMembantu("Kesibukan karir Bapak/Ibu bukan penghalang dalam memantau akademik putra-putri Anda")
        fragment3.setMembantu("Layanan aspirasi dan pengaduan online pada Sekolah dan Dinas Pendidikan")

        fragment1.setImage(R.drawable.ic_logo)
        fragment2.setImage(R.drawable.ic_onboarding_2)
        fragment3.setImage(R.drawable.ic_onboarding_3)

        adapter = myPagerAdapter(supportFragmentManager)
        adapter.list.add(fragment1)
        adapter.list.add(fragment2)
        adapter.list.add(fragment3)

        view_pager.adapter = adapter


        btnSkip.setOnClickListener {
            goToLoginActivity()
        }

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                if (p0 == adapter.list.size - 1) {
                    //lastpage
                    btnMulai.text = "MULAI"
                    btnMulai.setOnClickListener {
                        goToLoginActivity()
                    }
                } else {
                    //has next
                    btnMulai.text = ""
                    btnMulai.setOnClickListener {
                        view_pager.currentItem++
                    }

                }

                if (p0 == adapter.list.size - 1) {
                    //lastpage
                    btnSkip.text = ""
                    btnSkip.setOnClickListener {
                        view_pager.currentItem++
                    }
                } else {
                    //has next
                    btnSkip.text = "LEWATI"
                    btnSkip.setOnClickListener {
                        goToLoginActivity()
                    }

                }



                when (view_pager.currentItem) {
                    0 -> {
                        indicator1.setTextColor(ContextCompat.getColor(this@OnBoardingActivity, R.color.colorBlue))
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(Color.GRAY)
                    }
                    1 -> {
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(ContextCompat.getColor(this@OnBoardingActivity, R.color.colorBlue))
                        indicator3.setTextColor(Color.GRAY)
                    }
                    2 -> {
                        indicator1.setTextColor(Color.GRAY)
                        indicator2.setTextColor(Color.GRAY)
                        indicator3.setTextColor(ContextCompat.getColor(this@OnBoardingActivity, R.color.colorBlue))
                    }
                }
            }

        })
    }

    fun goToLoginActivity() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Waiting ...")
        progressDialog.setCancelable(false)
        progressDialog.show()
        startActivity(Intent(activity, LoginActivity::class.java))
        val editor = preference.edit()
        editor.putBoolean(pref_show, false)
        editor.apply()
        finish()
    }

    class myPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {

        val list: MutableList<Fragment> = ArrayList()

        override fun getItem(p0: Int): Fragment {
            return list[p0]
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}
