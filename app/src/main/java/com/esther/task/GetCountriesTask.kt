package com.esther.task

import com.esther.model.CountriesResponse
import com.esther.model.RequestData
import com.esther.network.TaskService
import com.esther.util.ApiConst
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GetCountriesTask : TaskService<RequestData, CountriesResponse>() {
    override fun getEndPoint(): String {
        return ApiConst.GET_COUNTRIES
    }

    override fun getMethod(): ApiConst.HttpMethodType {
        return ApiConst.HttpMethodType.GET
    }

    override fun genResponse(): CountriesResponse {
        val resultType= object : TypeToken<CountriesResponse>() {}.type
        return Gson().fromJson(Gson().toJson(responseBody), resultType)
    }
}