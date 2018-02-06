package com.testapp.di.component;


import com.testapp.app.TestApp;
import com.testapp.di.module.AppModule;
import com.testapp.screen.activity.home.HomeActivity;
import com.testapp.screen.activity.splash.SplashActivity;
import com.testapp.screen.fragment.homeFragment.HomeFragment;

import javax.inject.Singleton;

import dagger.Component;



@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {

    void inject(TestApp app);

    void inject(HomeActivity homeActivity);

    void inject(SplashActivity splashActivity);

    void inject(HomeFragment homeFragment);
}
