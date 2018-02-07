package com.testapp.screen.activity.splash;

import android.widget.TextView;

import com.testapp.R;
import com.testapp.app.TestApp;
import com.testapp.screen.activity.base.BaseActivity;
import com.testapp.screen.activity.home.HomeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashPresenter mPresenter;

    @BindView(R.id.logo_txt)
    TextView mLogoTxt;


    @Override
    protected void initializeDagger() {
        TestApp app = TestApp.getAppInstance(this);
        app.getAppComponent().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.mPresenter = mPresenter;
        mPresenter.setView(SplashActivity.this);
    }

    @Override
    protected void initComponent() {
        mLogoTxt.setAlpha(0.0f);
        mLogoTxt.animate().alpha(1).setDuration(1500).start();
    }

    @Override
    protected void bindView() {
        setUnBinder(ButterKnife.bind(this));
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_spalsh;
    }


    @Override
    protected void onResume() {
        super.onResume();
        /*handler initialization*/
        mPresenter.startHandler();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.stopHandler();
    }


    @Override
    public void navigate() {
        if (!isFinishing()) {
            startActivity(HomeActivity.class, null, null, true);
        }
    }
}
