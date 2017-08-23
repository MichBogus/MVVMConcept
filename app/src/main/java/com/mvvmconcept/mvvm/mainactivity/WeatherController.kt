package com.mvvmconcept.mvvm.mainactivity

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent
import android.widget.EditText

open class WeatherController : DataBindingComponent {

    override fun getCompanion(): Companion = this.companion

    companion object {
        @JvmStatic
        @BindingAdapter("textChangedListener")
        fun addTextChangedListener(editText: EditText, controller: WeatherController) {
            val test = ""
        }
    }

    fun onRollButtonClickListener(locationModel: WeatherLocationModel) {
        locationModel.cityName = "aaa"
        locationModel.countryCode = "222222222"
    }
}