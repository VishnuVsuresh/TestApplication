package com.testapp.screen.fragment.homeFragment;

import android.content.Context;

import com.testapp.screen.activity.base.Presenter;

import javax.inject.Inject;


public class HomeFragmentPresenter extends Presenter<HomeFragmentContract.View> implements HomeFragmentContract.Presenter {

    private Context mContext;

    @Inject
    public HomeFragmentPresenter(Context context) {
        this.mContext = context;
    }
}

