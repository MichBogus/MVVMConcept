package com.mvvmconcept.mvvm.mainactivity

import android.databinding.BindingAdapter
import android.databinding.DataBindingComponent
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

open class WeatherController : DataBindingComponent {

    override fun getCompanion(): Companion = this.companion

    companion object {
        @JvmStatic
        @BindingAdapter("textChangedListener")
        fun addTextChangedListener(editText: EditText, shouldAttach: Boolean) {
            if (shouldAttach) {
                editText.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {

                    }

                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

                    }

                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    }
                })
            }
        }
    }

    fun onRollButtonClickListener(locationModel: WeatherLocationModel) {
        locationModel.cityName = "aaa"
        locationModel.countryCode = "222222222"
    }
}