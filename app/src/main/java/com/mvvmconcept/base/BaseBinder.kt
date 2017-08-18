package com.mvvmconcept.base

import android.databinding.DataBindingUtil.setContentView
import android.databinding.ViewDataBinding

abstract class BaseBinder<in T : BaseActivity, in G : ViewDataBinding> {

    protected var activityBinding: ViewDataBinding? = null

    open fun attachBinding(activity: T, layout: Int) {
        activityBinding = setContentView<G>(activity, layout)
    }

    open fun detachBinding() {
        activityBinding = null
    }
}