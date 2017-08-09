package com.mvvmconcept

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.mvvmconcept.base.BaseActivity
import com.mvvmconcept.databinding.ActivityMainBinding
import com.mvvmconcept.mvvm.mainactivity.WeatherModel

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.weather = WeatherModel().apply {
            location = "a"
            locationTemperature = "20"
        }
    }
}