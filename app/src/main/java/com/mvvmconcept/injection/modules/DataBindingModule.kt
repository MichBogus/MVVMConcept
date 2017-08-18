package com.mvvmconcept.injection.modules

import com.mvvmconcept.mvvm.mainactivity.WeatherController
import com.mvvmconcept.mvvm.mainactivity.WeatherModel
import dagger.Module
import dagger.Provides

@Module
class DataBindingModule {

    @Provides
    fun provideWeatherController() =
            WeatherController()

    @Provides
    fun provideWeatherModel() =
            WeatherModel()
}