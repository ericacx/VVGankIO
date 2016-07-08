package com.gank.io.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gank.io.activity.BaseActivity;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/5.
 */

public abstract class BaseFragment extends Fragment {
    protected BaseActivity baseActivity;

    protected abstract int getLayoutId();

    public abstract void initView(View view, Bundle savedInstanceState);

    protected BaseActivity getBaseActivity(){
        return baseActivity;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), null);
        initView(view, savedInstanceState);
        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.baseActivity= (BaseActivity) activity;
    }

    public void addFragment(BaseFragment fragment){

    }

    public void removeFragment(BaseFragment fragment){

    }

}
