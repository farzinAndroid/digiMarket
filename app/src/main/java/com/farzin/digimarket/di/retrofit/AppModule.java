package com.farzin.digimarket.di.retrofit;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    // از کلاس اپلیکیشن استفاده میکنیم تا به رتروفیت در همه جا دسترسی داشته باشیم
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }


    @Provides
    @Singleton
    Application provideApplication(){
        return application = new Application();
    }
}
