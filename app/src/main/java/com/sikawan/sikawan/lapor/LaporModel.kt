package com.sikawan.sikawan.lapor

import com.google.gson.annotations.SerializedName

data class LaporModel(
        @SerializedName("id") val id: Int?,
        @SerializedName("judul") val judul: String?,
        @SerializedName("isi") val isi: String?,
        @SerializedName("gambar") val gambar: String?,
        @SerializedName("status") val status: String?,
        @SerializedName("user_id") val user_id: String?,
        @SerializedName("created_at") val created_at: String?,
        @SerializedName("updated_at") val updated_at: String?,
        @SerializedName("sekolah_id") val sekolah_id: String?,
        @SerializedName("balasan") val balasan: String?
)