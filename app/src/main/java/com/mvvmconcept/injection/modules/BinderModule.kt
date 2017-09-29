package com.mvvmconcept.injection.modules

import com.mvvmconcept.mvvm.mainactivity.TemperatureActivityBinder
import com.mvvmconcept.mvvm.mainactivity.WeatherController
import com.mvvmconcept.mvvm.mainactivity.WeatherLocationModel
import dagger.Module
import dagger.Provides

@Module
class BinderModule {

    @Provides
    fun provideMainActivityBinder(weatherLocationModel: WeatherLocationModel,
                                  weatherController: WeatherController) =
            TemperatureActivityBinder(weatherLocationModel, weatherController)
}