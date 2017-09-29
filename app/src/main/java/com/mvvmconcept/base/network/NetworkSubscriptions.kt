package com.mvvmconcept.base.network

import io.reactivex.disposables.Disposable
import java.util.*

class NetworkSubscriptions : NetworkSubscriptionsApi {

    private val subscriptions = HashMap<String, MutableList<Disposable>>()

    private fun getSubscriberTag(subscriber: Any): String {
        return subscriber.toString()
    }

    override fun getSubscriptions(subscriber: Any): MutableList<Disposable> {
        val tag = getSubscriberTag(subscriber)
        var objectSubscriptions: MutableList<Disposable>? = subscriptions[tag]
        if (objectSubscriptions == null) {
            objectSubscriptions = ArrayList<Disposable>()
            subscriptions.put(tag, objectSubscriptions)
        }
        return objectSubscriptions
    }

    override fun dispose(subscriber: Any): Int {
        val tag = getSubscriberTag(subscriber)

        if (!subscriptions.containsKey(tag)) {
            return 0
        }

        val taggedSubscriptions =
                if (this.subscriptions.containsKey(tag))
                    this.subscriptions[tag]!!
                else
                    mutableListOf()

        val numberOfSubscriptions = taggedSubscriptions.size
        for (subscription in taggedSubscriptions) {
            subscription.dispose()
        }
        subscriptions.remove(tag)
        return numberOfSubscriptions
    }
}