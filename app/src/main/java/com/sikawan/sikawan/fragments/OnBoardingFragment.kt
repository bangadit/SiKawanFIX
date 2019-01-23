package com.sikawan.sikawan.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.sikawan.sikawan.R
import kotlinx.android.synthetic.main.activity_on_boarding.view.*
import kotlinx.android.synthetic.main.fragment_on_boarding.*

class OnBoardingFragment : Fragment() {

    var pageTitle: String = ""
    var pageMembantu: String = ""
    var pageImage: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tvSiKawan.text = pageTitle
        tvMembantu.text = pageMembantu
        ic_logo.setImageResource(pageImage)
    }

    fun setTitle(title: String) {
        pageTitle = title
    }

    fun setMembantu(title: String){
        pageMembantu = title
    }

    fun setImage(image: Int){
        pageImage = image
    }
}
