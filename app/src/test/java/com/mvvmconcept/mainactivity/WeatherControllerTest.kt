package com.mvvmconcept.mainactivity

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

    @Before
    fun setUp() {
        systemUnderTest = spy(WeatherController())
    }

    @Test
    fun shouldPassProperDataAfterRollButtonClick() {
        systemUnderTest.onRollButtonClickListener(mockOfWeatherModel)

        assertThat(mockOfWeatherModel.cityName).isEqualTo("aaa")
        assertThat(mockOfWeatherModel.countryCode).isEqualTo("222222222")
    }
}