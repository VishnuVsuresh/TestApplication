package com.testapp.screen.activity.home;

import android.content.Context;

import com.testapp.screen.activity.base.Presenter;

import javax.inject.Inject;

public class HomePresenter extends Presenter<HomeContract.View> implements HomeContract.Presenter {

    private Context mContext;

    @Inject
    public HomePresenter(Context context) {
        this.mContext = context;
    }


}
