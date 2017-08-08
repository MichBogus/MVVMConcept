package com.mvvmconcept.mvvm.mainactivity

import android.databinding.Bindable
import com.mvvmconcept.BR
import com.mvvmconcept.base.BaseModel

class WeatherModel : BaseModel() {

    var location: String
        set(value) {
            location = value
            notifyPropertyChanged(BR.location)
        }
        @Bindable get() = location

    var locationTemperature: String
        set(value) {
            locationTemperature = value
            notifyPropertyChanged(BR.locationTemperature)
        }
        @Bindable get() = locationTemperature
}