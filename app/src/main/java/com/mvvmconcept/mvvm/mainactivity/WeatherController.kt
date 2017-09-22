package com.mvvmconcept.mvvm.mainactivity

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.mvvmconcept.api.WeatherCheckApi
import com.mvvmconcept.base.network.NetworkSchedulerApi
import io.reactivex.functions.Consumer

open class WeatherController(val scheduler: NetworkSchedulerApi,
                             val weatherCheckApi: WeatherCheckApi) : DataBindingComponent {

    override fun getCompanion(): Companion = this.companion

    companion object {

        private const val CITY_MINIMUM_CHAR_LENGHT = 3

        @JvmStatic
        @BindingAdapter("weatherCityTextChangedListener")
        fun addTextChangedListener(editText: EditText, controller: WeatherController) {
            editText.addTextChangedListener(object : TextWatcher {
                override fun afterTextChanged(s: Editable?) {

                }

                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    if (count > CITY_MINIMUM_CHAR_LENGHT) {
                        controller.downloadProperWeatherForLocation(s.toString())
                    }
                }
            })
        }
    }

    private fun downloadProperWeatherForLocation(cityName: String) {
        scheduler.schedule(weatherCheckApi.getWeatherForCity(cityName),
                Consumer {

                },
                Consumer {

                })
    }

    fun onRollButtonClickListener(locationModel: WeatherLocationModel) {
        locationModel.cityName = "aaa"
        locationModel.countryCode = "222222222"
    }
}