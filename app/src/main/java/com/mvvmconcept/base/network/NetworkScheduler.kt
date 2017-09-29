package com.mvvmconcept.base.network

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.functions.Consumer

class NetworkScheduler(private val observingScheduler: Scheduler, private val executingScheduler: Scheduler, val networkSubscriptionsApi: NetworkSubscriptionsApi) : NetworkSchedulerApi {

    override fun <T> schedule(single: Single<T>, onSuccess: Consumer<T>, onFail: Consumer<Throwable>, tag: Any) {
        val subscriptions = networkSubscriptionsApi.getSubscriptions(tag)
        subscriptions.add(single
                .observeOn(observingScheduler)
                .subscribeOn(executingScheduler)
                .subscribe(onSuccess, onFail))
    }

    override fun dispose(tag: Any) {
        networkSubscriptionsApi.dispose(tag)
    }
}