package com.testapp.di.module;


import android.content.Context;
import com.testapp.app.TestApp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private TestApp mApp;

    public AppModule(TestApp app) {
        mApp = app;
    }


    @Provides
    @Singleton
    Context provideContext() {
        return mApp;
    }

}
