package com.gank.io.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

import com.gank.io.fragment.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * *          _       _
 * *   __   _(_)_   _(_) __ _ _ __
 * *   \ \ / / \ \ / / |/ _` | '_ \
 * *    \ V /| |\ V /| | (_| | | | |
 * *     \_/ |_| \_/ |_|\__,_|_| |_|
 * <p>
 * Created by vivian on 16/7/5.
 */

public class BaseActivity extends AppCompatActivity {
    List<BaseFragment> fragmentList;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        fragmentList = new ArrayList<>();
    }

    public void addFragment(BaseFragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().add(fragment, fragment.getClass().getSimpleName()).commitAllowingStateLoss();
            fragmentList.add(fragment);
        }
    }

    public void removeFragment(BaseFragment fragment) {
        fragmentList.remove(fragment);
    }
}
