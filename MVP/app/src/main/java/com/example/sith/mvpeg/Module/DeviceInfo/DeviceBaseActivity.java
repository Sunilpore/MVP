package com.example.sith.mvpeg.Module.DeviceInfo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class DeviceBaseActivity extends AppCompatActivity {

    protected Activity mActivity;
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivity =this;
        mContext=this;
        init();
    }



    protected void init() {
        //Initialize Presenter


    }


}
