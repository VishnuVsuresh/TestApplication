package com.testapp.screen.fragment.homeFragment;

import android.view.View;

import com.testapp.R;
import com.testapp.app.TestApp;
import com.testapp.screen.activity.base.BaseFragment;

import javax.inject.Inject;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @Inject
    HomeFragmentPresenter mPresenter;


    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    protected void initializeDagger() {
        TestApp app = TestApp.getAppInstance(getActivity());
        app.getAppComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = mPresenter;
        mPresenter.setView(this);
    }

    @Override
    protected void initializeView(View view) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }
}
