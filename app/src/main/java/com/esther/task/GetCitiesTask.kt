package com.esther.task

import com.esther.model.CitiesResponse
import com.esther.model.RequestData
import com.esther.network.TaskService
import com.esther.util.ApiConst
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GetCitiesTask : TaskService<RequestData, CitiesResponse>() {
    override fun getEndPoint(): String {
        return ApiConst.GET_CITIES
    }

    override fun getMethod(): ApiConst.HttpMethodType {
        return ApiConst.HttpMethodType.GET
    }

    override fun genResponse(): CitiesResponse {
        val resultType= object : TypeToken<CitiesResponse>() {}.type
        return Gson().fromJson(Gson().toJson(responseBody), resultType)
    }
}