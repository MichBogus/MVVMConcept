package com.mvvmconcept.mvvm.mainactivity

import android.view.View
import com.mvvmconcept.base.BaseController

class WeatherController : BaseController() {

    fun onRollButtonClickListener(view: View, model: WeatherModel) {
        model.location = "aaa"
        model.locationTemperature = "222222222"
    }
}