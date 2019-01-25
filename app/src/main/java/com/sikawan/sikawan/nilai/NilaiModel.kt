package com.sikawan.sikawan.nilai

import com.google.gson.annotations.SerializedName

data class NilaiModel(
        @SerializedName("id") val id: Int?,
        @SerializedName("nilai") val nilai: String?,
        @SerializedName("pegawai_id") val pegawai_id: String?,
        @SerializedName("mapel_id") val mapel_id: String?,
        @SerializedName("id_ujian") val id_ujian: String?
)

//data class Userr(
//        @SerializedName("id") val id_user: Int?,
//        @SerializedName("username") val username: String?,
//        @SerializedName("password_digest") val password_digest: String?,
//        @SerializedName("nama_murid") val nama_murid: String?,
//        @SerializedName("alamat") val alamat: String?,
//        @SerializedName("email") val email: String?,
//        @SerializedName("sekolah_id") val sekolah_id: String?,
//        @SerializedName("created_at") val created_at: String?,
//        @SerializedName("updated_at") val updated_at: String?,
//        @SerializedName("role") val role: String?,
//        @SerializedName("kelass_id") val kelass_id: String?,
//        @SerializedName("nama_ortu") val nama_ortu: String?,
//        @SerializedName("avatar") val avatar: Avatarr?,
//        @SerializedName("tempat_lahir") val tempat_lahir: String?,
//        @SerializedName("nama_sekolah") val nama_sekolah: String?,
//        @SerializedName("birth_date") val birth_date: String?
//)
//
//data class Avatarr(
//        @SerializedName("url") val url: String?
//)
