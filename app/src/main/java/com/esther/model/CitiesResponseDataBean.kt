package com.esther.model


import com.google.gson.annotations.SerializedName

data class CitiesResponseDataBean(
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
    var recovered: Any? = null,
    @SerializedName("updated")
    var updated: String? = null,
    @SerializedName("velocity_confirmed")
    var velocityConfirmed: Int? = null,
    @SerializedName("velocity_dead")
    var velocityDead: Int? = null,
    @SerializedName("velocity_recovered")
    var velocityRecovered: Int? = null
)