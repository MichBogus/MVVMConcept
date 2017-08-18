package com.mvvmconcept.mvvm.mainactivity

import android.databinding.Bindable
import android.os.Bundle
import com.mvvmconcept.BR
import com.mvvmconcept.base.BaseModel

open class WeatherModel : BaseModel() {

    companion object {
        const val STATE_LOCATION = "state.location"
        const val STATE_LOCATION_TEMPERATURE = "state.location.temperature"
    }

    var location: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.location)
        }
        @Bindable get

    var locationTemperature: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.locationTemperature)
        }
        @Bindable get

    override fun onSaveState(bundle: Bundle?) {
        bundle?.putString(STATE_LOCATION, location)
        bundle?.putString(STATE_LOCATION_TEMPERATURE, locationTemperature)
    }

    override fun onRestoreState(bundle: Bundle?) {
        location = bundle?.getString(STATE_LOCATION) ?: ""
        locationTemperature = bundle?.getString(STATE_LOCATION_TEMPERATURE) ?: ""
    }
}