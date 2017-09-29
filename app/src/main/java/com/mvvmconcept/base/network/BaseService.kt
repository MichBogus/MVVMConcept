package com.mvvmconcept.base.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class BaseService(val client: OkHttpClient) {

    fun restAdapter() =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl("http://api.openweathermap.org/data/2.5/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
}