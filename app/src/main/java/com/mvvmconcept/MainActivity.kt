package com.mvvmconcept

import android.os.Bundle
import com.mvvmconcept.application.MVVMApplication
import com.mvvmconcept.base.BaseActivity
import com.mvvmconcept.mvvm.mainactivity.MainActivityBinder
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var mainActivityBinder: MainActivityBinder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MVVMApplication).injector.inject(this)
    }

    override fun onResume() {
        super.onResume()
        mainActivityBinder.attachBinding(this, R.layout.activity_main)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        mainActivityBinder.onSaveState(outState)
    }

    override fun onPause() {
        super.onPause()
        mainActivityBinder.detachBinding()
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        mainActivityBinder.onRestoreState(savedInstanceState)
        super.onRestoreInstanceState(savedInstanceState)
    }
}