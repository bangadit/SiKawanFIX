package com.sikawan.sikawan.nilai

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sikawan.sikawan.R
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.viewholder_nilai.view.*

class NilaiAdapter(val data: List<NilaiModel>, val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.viewholder_nilai, p0, false))
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
        private val textTanggal = view.nilai_1?.let {
            it
        }

        private val textTugas = view.jenisNilai1?.let {
            it
        }

        private val textPelajaran = view.matpel1?.let {
            it
        }

        private val textNilai = view.nilaimatpel1?.let {
            it
        }

        fun bindView(data: NilaiModel) {
            textNilai?.text = data.nilai
            textTugas?.text = data.id_ujian
            textPelajaran?.text = data.mapel_id
        }
    }
}