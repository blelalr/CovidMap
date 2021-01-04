package com.esther.model

import com.google.gson.annotations.SerializedName

data class ErrorData(
        @field:SerializedName("status_code")
        var statusCode: Int = -1,
        @field:SerializedName("status_message")
        var statusMessage: String = "",
        @field:SerializedName("success")
        var success: Boolean = false
)


