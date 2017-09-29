package com.mvvmconcept.api

import io.reactivex.Single

interface WeatherCheckApi {

    fun getWeatherForCity(cityName: String): Single<Any>
}