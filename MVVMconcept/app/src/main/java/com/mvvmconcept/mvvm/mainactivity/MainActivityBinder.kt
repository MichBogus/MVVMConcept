package com.mvvmconcept.mvvm.mainactivity

import com.mvvmconcept.MainActivity
import com.mvvmconcept.base.BaseBinder
import com.mvvmconcept.databinding.ActivityMainBinding


class MainActivityBinder(val weatherModel: WeatherModel,
                         val weatherController: WeatherController) : BaseBinder<MainActivity, ActivityMainBinding>() {

}