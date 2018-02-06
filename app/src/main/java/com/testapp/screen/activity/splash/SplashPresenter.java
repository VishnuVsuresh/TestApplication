package com.testapp.screen.activity.splash;

import android.content.Context;
import android.os.Handler;


import com.testapp.R;
import com.testapp.screen.activity.base.Presenter;

import javax.inject.Inject;


public class SplashPresenter extends Presenter<SplashContract.View> implements SplashContract.Presenter {

    private Context mContext;
    /*For setting delay for splash animation*/
    private Handler handler;
    private SplashHandler splashThread;

    @Inject
    public SplashPresenter(Context context) {
        this.mContext = context;
    }

    @Override
    public void takeToNextLevel() {
        // Check if user is signed in (non-null) and update UI accordingly.

    }

    @Override
    public void startHandler() {
        handler = new Handler();
        splashThread = new SplashHandler();
        handler.postDelayed(splashThread,
                mContext.getResources().getInteger(R.integer.splash_timeout));
    }

    @Override
    public void stopHandler() {
 /*if app is minimized or destroyed this will invoke*/
        if (handler != null)
            handler.removeCallbacks(splashThread);
        handler = null;
        splashThread = null;
    }

    private class SplashHandler implements Runnable {

        @Override
        public void run() {
            getView().navigate();

        }
    }
}
