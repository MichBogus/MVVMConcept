package com.mvvmconcept.injection.modules

import com.mvvmconcept.api.WeatherCheckApi
import com.mvvmconcept.base.network.NetworkSchedulerApi
import com.mvvmconcept.mvvm.mainactivity.WeatherController
import com.mvvmconcept.mvvm.mainactivity.WeatherLocationModel
import dagger.Module
import dagger.Provides

@Module
class DataBindingModule {

    @Provides
    fun provideWeatherController(networkSchedulerApi: NetworkSchedulerApi,
                                 weatherCheckApi: WeatherCheckApi) =
            WeatherController(networkSchedulerApi, weatherCheckApi)

    @Provides
    fun provideWeatherModel() =
            WeatherLocationModel()
}