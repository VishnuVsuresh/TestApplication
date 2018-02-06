package com.testapp.screen.activity.home;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;

import com.testapp.R;
import com.testapp.app.TestApp;
import com.testapp.screen.activity.base.BaseActivity;
import com.testapp.screen.fragment.homeFragment.HomeFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements HomeContract.View {


    @Inject
    HomePresenter mPresenter;


    @Override
    protected void initializeDagger() {
        TestApp app = TestApp.getAppInstance(this);
        app.getAppComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.mPresenter = mPresenter;
        mPresenter.setView(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    protected void initComponent() {
        initToolBar(false, getString(R.string.nommo_pro));

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, HomeFragment.newInstance());
        fragmentTransaction.commit();
    }

    @Override
    protected void bindView() {
        setUnBinder(ButterKnife.bind(this));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

}
