package com.farzin.digimarket.di.retrofit;


import com.farzin.digimarket.MainActivity;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApiModule.class, AppModule.class})
public interface ApiComponent {

    void inject(MainActivity mainActivity);

}
