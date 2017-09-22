package com.mvvmconcept.mvvm.mainactivity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.mvvmconcept.TemperatureActivity
import com.mvvmconcept.base.BaseBinder
import com.mvvmconcept.databinding.ActivityMainBinding
import com.mvvmconcept.mvvm.shared.StateManager

class TemperatureActivityBinder(val weatherLocationModel: WeatherLocationModel,
                                val weatherController: WeatherController) : BaseBinder<TemperatureActivity, ActivityMainBinding>(), StateManager {

    override fun attachBinding(activity: TemperatureActivity, layout: Int) {
        super.attachBinding(activity, layout)
        DataBindingUtil.setDefaultComponent(weatherController)
        (activityBinding as ActivityMainBinding).controller = weatherController
        (activityBinding as ActivityMainBinding).weather = weatherLocationModel
    }

    override fun detachBinding() {
        super.detachBinding()

        weatherController.disposeConnections()
    }

    override fun onSaveState(bundle: Bundle?) {
        weatherLocationModel.onSaveState(bundle)
    }

    override fun onRestoreState(bundle: Bundle?) {
        weatherLocationModel.onRestoreState(bundle)
    }
}