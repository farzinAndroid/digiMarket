package com.farzin.digimarket.di.user;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {



    @Provides
    @Singleton
    ContactUser provideContacts(){
        return new ContactUser();
    }

    @Provides
    @Singleton
    UserProfile provideUser(){
        return new UserProfile(new ContactUser());
    }
}
