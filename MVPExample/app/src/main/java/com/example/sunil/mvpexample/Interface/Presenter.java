package com.example.sunil.mvpexample.Interface;

/**
 * Created by Sunil on 1/29/2018.
 */

public interface Presenter {

    public void onCreate();

    public void onStart();

    public void onRestart();

    public void onStop(boolean s);

    public void onResume();

    public void onPause();

    public void onDestroy();

}
