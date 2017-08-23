package com.mvvmconcept.mvvm.mainactivity

import android.databinding.Bindable
import android.os.Bundle
import com.mvvmconcept.BR
import com.mvvmconcept.base.BaseModel

open class WeatherLocationModel : BaseModel() {

    companion object {
        const val STATE_CITY_NAME = "state.city.name"
        const val STATE_COUNTRY_CODE = "state.country.code"
    }

    var cityName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.cityName)
        }
        @Bindable get

    var countryCode: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.countryCode)
        }
        @Bindable get

    override fun onSaveState(bundle: Bundle?) {
        bundle?.putString(STATE_CITY_NAME, cityName)
        bundle?.putString(STATE_COUNTRY_CODE, countryCode)
    }

    override fun onRestoreState(bundle: Bundle?) {
        cityName = bundle?.getString(STATE_CITY_NAME) ?: ""
        countryCode = bundle?.getString(STATE_COUNTRY_CODE) ?: ""
    }
}