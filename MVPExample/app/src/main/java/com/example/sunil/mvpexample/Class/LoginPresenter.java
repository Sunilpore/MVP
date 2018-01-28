package com.example.sunil.mvpexample.Class;

import com.example.sunil.mvpexample.Interface.LoginCallback;
import com.example.sunil.mvpexample.Interface.Presenter;

/**
 * Created by Sunil on 1/29/2018.
 */

public class LoginPresenter implements Presenter {
    LoginCallback mLoginCallback;

    public void setLoginCallback(LoginCallback loginCallback) {
        this.mLoginCallback = loginCallback;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onStop(boolean s) {
        boolean status = s;
        mLoginCallback.setCallback(status);
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }
}