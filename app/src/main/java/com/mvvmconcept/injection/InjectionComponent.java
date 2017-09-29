package com.mvvmconcept.injection;

import com.mvvmconcept.TemperatureActivity;
import com.mvvmconcept.base.BaseActivity;
import com.mvvmconcept.injection.modules.BinderModule;
import com.mvvmconcept.injection.modules.DataBindingModule;
import com.mvvmconcept.injection.modules.NetworkModule;
import com.mvvmconcept.injection.modules.ServicesModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataBindingModule.class,
        BinderModule.class,
        NetworkModule.class,
        ServicesModule.class})
public interface InjectionComponent {

    void inject(BaseActivity baseActivity);

    void inject(TemperatureActivity temperatureActivity);
}
