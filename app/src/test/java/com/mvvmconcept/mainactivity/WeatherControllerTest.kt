package com.mvvmconcept.mainactivity

import com.mvvmconcept.api.WeatherCheckApi
import com.mvvmconcept.base.network.NetworkSchedulerApi
import com.mvvmconcept.mvvm.mainactivity.WeatherController
import com.mvvmconcept.mvvm.mainactivity.WeatherLocationModel
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.spy
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherControllerTest {

    lateinit var systemUnderTest: WeatherController

    var mockOfWeatherModel = mock<WeatherLocationModel>()
    var mockOfWearcherCheckApi = mock<WeatherCheckApi>()
    var mockOfScheduler = mock<NetworkSchedulerApi>()

    @Before
    fun setUp() {
        systemUnderTest = spy(WeatherController(mockOfScheduler, mockOfWearcherCheckApi))
    }

    @Test
    fun shouldPassProperDataAfterRollButtonClick() {
        systemUnderTest.onRollButtonClickListener(mockOfWeatherModel)

        assertThat(mockOfWeatherModel.cityName).isEqualTo("aaa")
        assertThat(mockOfWeatherModel.countryCode).isEqualTo("222222222")
    }
}