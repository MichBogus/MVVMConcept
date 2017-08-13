package com.mvvmconcept.mvvm.mainactivity

import android.databinding.Bindable
import com.mvvmconcept.BR
import com.mvvmconcept.base.BaseModel

class WeatherModel : BaseModel() {

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
}