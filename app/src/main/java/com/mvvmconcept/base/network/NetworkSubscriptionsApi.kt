package com.mvvmconcept.base.network

import io.reactivex.disposables.Disposable


interface NetworkSubscriptionsApi {

    fun getSubscriptions(subscriber: Any): MutableList<Disposable>
    fun dispose(subscriber: Any): Int
}