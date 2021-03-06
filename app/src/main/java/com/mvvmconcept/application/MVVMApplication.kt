package com.mvvmconcept.application

import android.support.multidex.MultiDexApplication
import com.mvvmconcept.injection.DaggerInjectionComponent
import com.mvvmconcept.injection.InjectionComponent
import com.mvvmconcept.injection.modules.BinderModule
import com.mvvmconcept.injection.modules.DataBindingModule
import com.mvvmconcept.injection.modules.NetworkModule
import com.mvvmconcept.injection.modules.ServicesModule

class MVVMApplication : MultiDexApplication() {

    lateinit var injector: InjectionComponent

    override fun onCreate() {
        super.onCreate()

        buildInjector()
    }

    private fun buildInjector() {
        injector = DaggerInjectionComponent.builder()
                .binderModule(BinderModule())
                .dataBindingModule(DataBindingModule())
                .networkModule(NetworkModule())
                .servicesModule(ServicesModule())
                .build()
    }
}