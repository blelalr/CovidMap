package com.esther.network

import com.esther.model.ErrorData


sealed class ApiResult<out T> {
    data class Success<out T >(val data: T) : ApiResult<T>()
    data class Error(val errorData: ErrorData) : ApiResult<Nothing>()
    data class Exception(val exception: java.lang.Exception) : ApiResult<Nothing>()
}