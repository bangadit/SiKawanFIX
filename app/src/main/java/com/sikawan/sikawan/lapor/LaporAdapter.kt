package com.sikawan.sikawan.lapor

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sikawan.sikawan.DetailLaporActivity
import com.sikawan.sikawan.R
import kotlinx.android.synthetic.main.viewholder_daftar_laporan.view.*

class LaporAdapter(val data: List<LaporModel>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.viewholder_daftar_laporan, p0, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bindView(data[position])
        }
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textJudul = view.tvJudul?.let {
            it
        }

        private val textIsi = view.tvIsi?.let {
            it
        }

        fun bindView(data: LaporModel) {
            textJudul?.text = data.judul
            textIsi?.text = data.isi
            itemView.setOnClickListener {
                context.startActivity(Intent(context, DetailLaporActivity::class.java).apply {
                    putExtra("id", data.id)
                })
            }
        }
    }
}