package com.mvvmconcept.injection.modules

import com.mvvmconcept.base.network.NetworkScheduler
import com.mvvmconcept.base.network.NetworkSchedulerApi
import com.mvvmconcept.base.network.NetworkSubscriptions
import com.mvvmconcept.base.network.NetworkSubscriptionsApi
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        const val CONNECTION_TIMEOUT_IN_SECONDS = 30L
        const val SOCKET_READ_TIMEOUT_IN_SECONDS = 30L
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient =
            OkHttpClient.Builder().apply {
                connectTimeout(CONNECTION_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                readTimeout(SOCKET_READ_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)

                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY

                addInterceptor(logging)
            }.build()

    @Singleton
    @Provides
    fun provideNetworkSubscriptions(): NetworkSubscriptionsApi =
            NetworkSubscriptions()

    @Provides
    fun provideNetworkScheduler(networkSubscriptionsApi: NetworkSubscriptionsApi): NetworkSchedulerApi =
            NetworkScheduler(AndroidSchedulers.mainThread(), Schedulers.io(), networkSubscriptionsApi)
}
