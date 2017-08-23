package com.mvvmconcept

import android.os.Bundle
import com.mvvmconcept.application.MVVMApplication
import com.mvvmconcept.base.BaseActivity
import com.mvvmconcept.mvvm.mainactivity.TemperatureActivityBinder
import javax.inject.Inject

class TemperatureActivity : BaseActivity() {

    @Inject
    lateinit var temperatureActivityBinder: TemperatureActivityBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MVVMApplication).injector.inject(this)
    }

    override fun onResume() {
        super.onResume()
        temperatureActivityBinder.attachBinding(this, R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        temperatureActivityBinder.onSaveState(outState)
    }

    override fun onPause() {
        super.onPause()
        temperatureActivityBinder.detachBinding()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        temperatureActivityBinder.onRestoreState(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }
}