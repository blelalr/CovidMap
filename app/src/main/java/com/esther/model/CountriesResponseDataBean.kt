package com.esther.model


import com.google.gson.annotations.SerializedName

data class CountriesResponseDataBean(
    @SerializedName("confirmed")
    var confirmed: Int? = null,
    @SerializedName("country_code")
    var countryCode: String? = null,
    @SerializedName("dead")
    var dead: Int? = null,
    @SerializedName("latitude")
    var latitude: Double? = null,
    @SerializedName("location")
    var location: String? = null,
    @SerializedName("longitude")
    var longitude: Double? = null,
    @SerializedName("recovered")
    var recovered: Int? = null,
    @SerializedName("updated")
    var updated: String? = null
)