package com.sikawan.sikawan.nilai

import com.google.gson.annotations.SerializedName

data class NilaiModel(
        @SerializedName("id") val id: Int?,
        @SerializedName("nilai") val nilai: String?,
        @SerializedName("user_id") val user_id: String?,
        @SerializedName("pegawai_id") val pegawai_id: String?,
        @SerializedName("id_mapel") val id_mapel: String?,
        @SerializedName("id_ujian") val id_ujian: String?,
        @SerializedName("created_at") val created_at: String?,
        @SerializedName("updated_at") val updated_at: String?
)