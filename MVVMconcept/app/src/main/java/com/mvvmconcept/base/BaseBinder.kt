package com.mvvmconcept.base

import android.databinding.DataBindingUtil.setContentView
import android.databinding.ViewDataBinding

abstract class BaseBinder<in T : BaseActivity, in G : ViewDataBinding> {

    var activityBinding: ViewDataBinding? = null

    fun attachBinding(activity: T, layout: Int) {
        activityBinding = setContentView<G>(activity, layout)
    }

    fun detachBinding() {
        activityBinding = null
    }
}