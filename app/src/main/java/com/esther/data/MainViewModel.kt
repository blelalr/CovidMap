package com.esther.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.esther.model.CountriesResponse
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    fun getCountries() : MutableLiveData<CountriesResponse>{
       val countriesData = MutableLiveData<CountriesResponse>()
        viewModelScope.launch {
            countriesData.value = CovidMapRepository().getMapOfCountries().value
        }
        return countriesData
    }
}