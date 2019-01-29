package com.example.sith.mvpeg.Class;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.sith.mvpeg.SingltonHelper.PreferenceHelper;

/**
 * Created by Sunil on 1/29/2018.
 */


//Use only 1 Base Activity throghout the application and intialize common parameter here which is used all over in same Activity class.
// Like, Sharedpreference,context,activity,etc.
public abstract class BaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    protected Context mContext;
    protected PreferenceHelper mPreferenceHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity =this;
        mContext=this;
        mPreferenceHelper = PreferenceHelper.getmInstance(this);
        init();
    }

    protected abstract void init();
}
