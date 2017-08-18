package com.mvvmconcept.mvvm.mainactivity

import android.os.Bundle
import com.mvvmconcept.MainActivity
import com.mvvmconcept.base.BaseBinder
import com.mvvmconcept.databinding.ActivityMainBinding
import com.mvvmconcept.mvvm.shared.StateManager

class MainActivityBinder(val weatherModel: WeatherModel,
                         val weatherController: WeatherController) : BaseBinder<MainActivity, ActivityMainBinding>(), StateManager {

    override fun attachBinding(activity: MainActivity, layout: Int) {
        super.attachBinding(activity, layout)
        (activityBinding as ActivityMainBinding).controller = weatherController
        (activityBinding as ActivityMainBinding).weather = weatherModel
    }

    override fun onSaveState(bundle: Bundle?) {
        weatherModel.onSaveState(bundle)
    }

    override fun onRestoreState(bundle: Bundle?) {
        weatherModel.onRestoreState(bundle)
    }
}