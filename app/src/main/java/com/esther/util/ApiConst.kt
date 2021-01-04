package com.esther.util

object ApiConst {

    enum class HttpMethodType {
        GET, POST
    }

    const val BASE_URL: String = "https://www.trackcorona.live/"

    //Api end point
    const val GET_COUNTRIES: String = "api/countries"
    const val GET_PROVINCES: String = "api/provinces"
    const val GET_CITIES: String = "api/cities"
    const val GET_TRAVEL: String = "api/travel"

}