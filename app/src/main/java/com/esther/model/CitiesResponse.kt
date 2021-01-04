package com.esther.model


import com.google.gson.annotations.SerializedName

data class CitiesResponse(
    @SerializedName("code")
    var code: Int? = null,
    @SerializedName("data")
    var `data`: List<CitiesResponseDataBean>? = null
)