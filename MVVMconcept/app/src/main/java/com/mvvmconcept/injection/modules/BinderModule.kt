package com.mvvmconcept.injection.modules

import com.mvvmconcept.mvvm.mainactivity.MainActivityBinder
import com.mvvmconcept.mvvm.mainactivity.WeatherController
import com.mvvmconcept.mvvm.mainactivity.WeatherModel
import dagger.Module
import dagger.Provides

@Module
class BinderModule {

    @Provides
    fun provideMainActivityBinder(weatherModel: WeatherModel,
                                  weatherController: WeatherController) =
            MainActivityBinder(weatherModel, weatherController)
}