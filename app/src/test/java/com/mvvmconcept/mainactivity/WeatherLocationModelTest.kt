package com.mvvmconcept.mainactivity

import android.os.Bundle
import com.mvvmconcept.mvvm.mainactivity.WeatherLocationModel
import com.nhaarman.mockito_kotlin.spy
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherLocationModelTest {

    lateinit var systemUnderTest: WeatherLocationModel

    @Before
    fun steUp() {
        systemUnderTest = spy(WeatherLocationModel())
    }

    @Test
    fun shouldSaveStateProperly() {
        systemUnderTest.cityName = "abc"
        systemUnderTest.countryCode = "20"

        val mockOfBundle = Bundle()

        systemUnderTest.onSaveState(mockOfBundle)

        assertThat(mockOfBundle.getString(WeatherLocationModel.STATE_CITY_NAME)).isEqualTo("abc")
        assertThat(mockOfBundle.getString(WeatherLocationModel.STATE_COUNTRY_CODE)).isEqualTo("20")
    }

    @Test
    fun shouldRestoreStateProperly() {
        val mockOfBundle = Bundle()
        mockOfBundle.putString(WeatherLocationModel.STATE_CITY_NAME, "abc")
        mockOfBundle.putString(WeatherLocationModel.STATE_COUNTRY_CODE, "20")

        systemUnderTest.onRestoreState(mockOfBundle)

        assertThat(systemUnderTest.cityName).isEqualTo("abc")
        assertThat(systemUnderTest.countryCode).isEqualTo("20")
    }
}