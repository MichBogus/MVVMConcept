package com.mvvmconcept.api

import com.mvvmconcept.base.network.BaseService
import okhttp3.OkHttpClient


class WeatherCheckService(client: OkHttpClient) : BaseService(client), WeatherCheckApi {

    override fun getWeatherForCity(cityName: String) =
            restAdapter().create(WeatherCheckRetrofitApi::class.java).getWeatherForCity(cityName)

}