package com.esther.data

import androidx.lifecycle.MutableLiveData
import com.esther.model.CountriesResponse
import com.esther.network.ApiResult
import com.esther.network.TaskManager
import com.esther.task.GetCountriesTask
import com.esther.util.DebugLog

class CovidMapRepository : CovidMapRepo {
    override suspend fun getMapOfCountries(): MutableLiveData<CountriesResponse> {
        val countriesLiveData = MutableLiveData<CountriesResponse>()
        when(val result = TaskManager(GetCountriesTask()).startTask()) {
            is ApiResult.Success -> {
                DebugLog.d("${result.data}")
                countriesLiveData.value = result.data
            }
            is ApiResult.Error -> {
                DebugLog.d("${result.errorData}")
            }
            is ApiResult.Exception -> {
                DebugLog.d("${result.exception}")
            }
        }
        return countriesLiveData
    }


}