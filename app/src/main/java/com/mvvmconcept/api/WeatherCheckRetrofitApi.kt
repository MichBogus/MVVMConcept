package com.mvvmconcept.api

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherCheckRetrofitApi {

    @GET("weather")
    fun getWeatherForCity(@Query("q") cityName: String): Single<Any>

}