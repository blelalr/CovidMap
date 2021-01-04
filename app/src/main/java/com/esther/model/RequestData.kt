package com.esther.model


import com.google.gson.annotations.SerializedName

data class RequestData(
    @SerializedName("code")
    var code: String? = null,
    @SerializedName("name")
    var name: String? = null
)