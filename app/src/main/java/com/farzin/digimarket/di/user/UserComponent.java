package com.farzin.digimarket.di.user;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UserModule.class})
public interface UserComponent {

    UserProfile provideUser();
}
