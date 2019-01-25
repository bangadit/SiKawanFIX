package com.sikawan.sikawan.profil

import com.google.gson.annotations.SerializedName

data class ProfilModel(
        @SerializedName("id") val id: Int?,
        @SerializedName("username") val username: String?,
        @SerializedName("password_digest") val password_digest: String?,
        @SerializedName("nama_murid") val nama_murid: String?,
        @SerializedName("alamat") val alamat: String?,
        @SerializedName("email") val email: String?,
        @SerializedName("sekolah_id") val sekolah_id: String?,
        @SerializedName("nama_sekolah") val nama_sekolah: String?,
        @SerializedName("created_at") val created_at: String?,
        @SerializedName("updated_at") val updated_at: String?,
        @SerializedName("role") val role: String?,
        @SerializedName("kelass_id") val kelass_id: String?,
        @SerializedName("tgl_lhr") val tgl_lhr: String?,
        @SerializedName("nama_ortu") val nama_ortu: String?,
        @SerializedName("avatar") val avatar: Avatar?
)

data class Avatar(
        @SerializedName("url") val url: String?
)