package com.mvvmconcept.base.network

import io.reactivex.Single
import io.reactivex.functions.Consumer


interface NetworkSchedulerApi {

    fun <T> schedule(single: Single<T>, onSuccess: Consumer<T>, onFail: Consumer<Throwable>)
}