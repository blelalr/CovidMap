package com.esther.task

import com.esther.model.ProvincesResponse
import com.esther.model.RequestData
import com.esther.network.TaskService
import com.esther.util.ApiConst
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GetProvinceTask : TaskService<RequestData, ProvincesResponse>() {
    override fun getEndPoint(): String {
        return ApiConst.GET_PROVINCES
    }

    override fun getMethod(): ApiConst.HttpMethodType {
        return ApiConst.HttpMethodType.GET
    }

    override fun genResponse(): ProvincesResponse {
        val resultType= object : TypeToken<ProvincesResponse>() {}.type
        return Gson().fromJson(Gson().toJson(responseBody), resultType)
    }
}