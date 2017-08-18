package com.mvvmconcept.mainactivity

import android.os.Bundle
import com.mvvmconcept.mvvm.mainactivity.WeatherModel
import com.nhaarman.mockito_kotlin.spy
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class WeatherModelTest {

    lateinit var systemUnderTest: WeatherModel

    @Before
    fun steUp() {
        systemUnderTest = spy(WeatherModel())
    }

    @Test
    fun shouldSaveStateProperly() {
        systemUnderTest.location = "abc"
        systemUnderTest.locationTemperature = "20"

        val mockOfBundle = Bundle()

        systemUnderTest.onSaveState(mockOfBundle)

        assertThat(mockOfBundle.getString(WeatherModel.STATE_LOCATION)).isEqualTo("abc")
        assertThat(mockOfBundle.getString(WeatherModel.STATE_LOCATION_TEMPERATURE)).isEqualTo("20")
    }

    @Test
    fun shouldRestoreStateProperly() {
        val mockOfBundle = Bundle()
        mockOfBundle.putString(WeatherModel.STATE_LOCATION, "abc")
        mockOfBundle.putString(WeatherModel.STATE_LOCATION_TEMPERATURE, "20")

        systemUnderTest.onRestoreState(mockOfBundle)

        assertThat(systemUnderTest.location).isEqualTo("abc")
        assertThat(systemUnderTest.locationTemperature).isEqualTo("20")
    }
}