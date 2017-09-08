package com.mvvmconcept.base.network

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer

class NetworkScheduler(private val observingScheduler: Scheduler, private val executingScheduler: Scheduler) : NetworkSchedulerApi {

    override fun <T> schedule(single: Single<T>, onSuccess: Consumer<T>, onFail: Consumer<Throwable>) {
        single.subscribeOn(executingScheduler)
                .observeOn(observingScheduler)
                .subscribe(onSuccess, onFail)
    }
}