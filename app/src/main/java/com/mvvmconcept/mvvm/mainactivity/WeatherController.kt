package com.mvvmconcept.mvvm.mainactivity

import com.mvvmconcept.base.BaseController

open class WeatherController : BaseController() {

    fun onRollButtonClickListener(model: WeatherModel) {
        model.location = "aaa"
        model.locationTemperature = "222222222"
    }
}