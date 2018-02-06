package com.testapp.app;

import android.app.Application;
import android.content.Context;

import com.testapp.di.component.AppComponent;
import com.testapp.di.component.DaggerAppComponent;
import com.testapp.di.module.AppModule;


public class TestApp extends Application {

    private AppComponent appComponent;
    private static boolean sIsChatActivityOpen = false;

    public static TestApp getAppInstance(Context context) {
        return (TestApp) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        appComponent.inject(this);
    }





    public AppComponent getAppComponent() {
        return appComponent;
    }

}
