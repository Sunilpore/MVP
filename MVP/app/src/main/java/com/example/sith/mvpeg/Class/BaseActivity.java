package com.example.sith.mvpeg.Class;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sith.mvpeg.SingltonHelper.PreferenceHelper;

/**
 * Created by Sunil on 1/29/2018.
 */


public abstract class BaseActivity extends AppCompatActivity {

    protected PreferenceHelper mPreferenceHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferenceHelper = PreferenceHelper.getmInstance(this);
        init();
    }

    protected abstract void init();
}
