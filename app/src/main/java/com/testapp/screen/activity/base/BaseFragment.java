package com.testapp.screen.activity.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;

import butterknife.Unbinder;


/**
 * Created by Vishnu on 7/3/2017.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    protected FragmentManager fragmentManager;
    protected Presenter presenter;
    private View view;
    private Unbinder mUnBinder;

    protected abstract void initializeDagger();

    protected abstract void initializePresenter();

    protected abstract void initializeView(View view);

    public abstract int getLayoutId();
    protected abstract void bindView(View view);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getActivity().getSupportFragmentManager();
        initializeDagger();
        initializePresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        bindView(view);
        initializeView(view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.finalizeView();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    public void showLoading() {

    }

    public void hideLoading() {

    }

    public void hideKeyBoard() {

        try {
            View view = getActivity().getCurrentFocus();
            if (view != null) {
                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    protected void startActivity(Class<? extends Activity> activity, Bundle bundle, boolean isFinishParent) {

        Intent intent = new Intent(getActivity(), activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (isFinishParent) {
            getActivity().supportFinishAfterTransition();
        }
    }
    protected void startActivityForResult(Class<? extends Activity> activity, Bundle bundle, int requestCode) {
        Intent intent = new Intent(getActivity(), activity);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }


    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }


    protected void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }
}
