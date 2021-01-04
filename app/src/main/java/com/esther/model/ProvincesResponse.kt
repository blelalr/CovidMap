package com.esther.model


import com.google.gson.annotations.SerializedName

data class ProvincesResponse(
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("data")
    var `data`: List<ProvincesResponseDataBean>? = null
)