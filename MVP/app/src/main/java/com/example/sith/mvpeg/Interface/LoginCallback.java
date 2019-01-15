package com.example.sith.mvpeg.Interface;

/**
 * Created by Sunil on 1/29/2018.
 */

public interface LoginCallback {

    void setCallback(boolean loginCallback);

    void listenEvent(String event);
}
