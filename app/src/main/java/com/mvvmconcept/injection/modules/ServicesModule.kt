package com.mvvmconcept.injection.modules

import com.mvvmconcept.api.WeatherCheckApi
import com.mvvmconcept.api.WeatherCheckService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class ServicesModule {

    @Provides
    fun provideWeatherService(okHttpClient: OkHttpClient): WeatherCheckApi =
            WeatherCheckService(okHttpClient)
}