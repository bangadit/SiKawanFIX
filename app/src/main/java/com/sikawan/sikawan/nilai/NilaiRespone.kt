package com.sikawan.sikawan.nilai

import com.google.gson.annotations.SerializedName

data class NilaiRespone(@SerializedName("status") val status: String?,
                        @SerializedName("result") val result: List<NilaiModel>?,
                        @SerializedName("errors") val errors: String?
)