package com.sikawan.sikawan.lapor

import com.google.gson.annotations.SerializedName

data class DetailLaporRespon(@SerializedName("status") val status: String?,
                             @SerializedName("result") val result: LaporModel?,
                             @SerializedName("errors") val errors: String)