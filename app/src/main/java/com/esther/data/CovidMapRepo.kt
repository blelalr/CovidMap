package com.esther.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.esther.model.CountriesResponse
import com.esther.network.ApiResult

interface CovidMapRepo {

    suspend fun getMapOfCountries() : MutableLiveData<CountriesResponse>

}
