package com.testapp.screen.activity.splash;


import com.testapp.screen.activity.base.BaseView;

public class SplashContract {

    public interface View extends BaseView {
        void navigate();

    }


    interface Presenter {
        void takeToNextLevel();
        void startHandler();
        void stopHandler();
    }
}
