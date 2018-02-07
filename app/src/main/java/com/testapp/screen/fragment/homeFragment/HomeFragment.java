package com.testapp.screen.fragment.homeFragment;

import android.view.View;
import android.widget.ImageView;

import com.testapp.R;
import com.testapp.app.TestApp;
import com.testapp.screen.activity.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @Inject
    HomeFragmentPresenter mPresenter;

    @BindView(R.id.btSet)
    ImageView btSet;

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

    @OnClick({R.id.btSet, R.id.btPlug})
    public void doSomething() {
        // TODO something
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void bindView(View view) {
        setUnBinder(ButterKnife.bind(this, view));
    }
}
