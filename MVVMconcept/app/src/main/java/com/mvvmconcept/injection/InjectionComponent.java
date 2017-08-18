package com.mvvmconcept.injection;

import com.mvvmconcept.MainActivity;
import com.mvvmconcept.base.BaseActivity;
import com.mvvmconcept.injection.modules.BinderModule;
import com.mvvmconcept.injection.modules.DataBindingModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {DataBindingModule.class, BinderModule.class})
public interface InjectionComponent {
    void inject(BaseActivity baseActivity);
    void inject(MainActivity mainActivity);
}
