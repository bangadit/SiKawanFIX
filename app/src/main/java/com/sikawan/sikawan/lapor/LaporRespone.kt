package com.sikawan.sikawan.lapor

import com.google.gson.annotations.SerializedName

data class LaporRespone(@SerializedName("status") val status: String?,
                        @SerializedName("result") val result: List<LaporModel>?
)