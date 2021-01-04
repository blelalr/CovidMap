package com.esther.network

import com.esther.util.ApiConst
import com.esther.util.ApiConst.HttpMethodType.*
import com.esther.util.DebugLog
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class TaskManager<Request, Response> constructor(var taskService: TaskService<Request, Response>) {
    private var apiService = ApiServiceBuilder().apiService

    suspend fun startTask(): ApiResult<Response> {
        return withContext(Dispatchers.IO) {
            DebugLog.e("Task Start   : [Method] -- ${taskService.getMethod()}")
            val result = when (taskService.getMethod()) {
                GET -> {
                    if (taskService.requestData != null) {
                        apiService.get(taskService.getEndPoint(), taskService.genQueryMap())
                    } else {
                        apiService.get(taskService.getEndPoint())
                    }
                }
                POST -> {
                    apiService.post(taskService.getEndPoint(), taskService.requestData)
                }
            }

            DebugLog.e("Task Start   : [ Url ] -- ${ApiConst.BASE_URL}${taskService.getEndPoint()}")
            taskService.requestData?.let { DebugLog.e("Task Start   : [Request Data] -- ${taskService.requestData}") }

            return@withContext try {
                if (result.isSuccessful) {
                    taskService.responseBody = result.body()
                    val resObj = taskService.genResponse()
                    DebugLog.e("Task Response: [Success]\n${Gson().toJson(resObj)}")
                    ApiResult.Success(resObj)
                } else {
                    val errorObj = ApiServiceBuilder().parseError(result)
                    DebugLog.e("Task Response: [Error] --\n${Gson().toJson(errorObj)}")
                    ApiResult.Error(errorObj)
                }
            } catch (e: Exception) {
                DebugLog.e("Task Response: [Exception] -- Exception: $e")
                ApiResult.Exception(e)
            }

        }
    }
}