package com.example.sith.mvpeg.Class;

import android.content.Context;

import com.example.sith.mvpeg.Interface.LoginCallback;
import com.example.sith.mvpeg.Interface.Presenter;
import com.example.sith.mvpeg.Module.DeviceInfo.DeviceInfoActivity;
import com.example.sith.mvpeg.Module.Login.LoginActivity;
import com.example.sith.mvpeg.model.Event;
import com.example.sith.mvpeg.utils.constants.Constants;

/**
 * Created by Sunil on 1/29/2018.
 */

public class LoginPresenter implements Presenter {
    private LoginCallback mLoginCallback;

    public void setLoginCallback(LoginCallback loginCallback) {
        this.mLoginCallback = loginCallback;
    }



    @Override
    public void setMsg(boolean s) {
        mLoginCallback.setCallback(s);
    }

    @Override
    public void actionEvent(Context context,String eventMsg) {

        Event event = new Event();

        switch (eventMsg){

            case Constants.MainActivityTAG.LOGIN:
                eventMsg = event.isActionCompleted(Constants.MainActivityTAG.LOGIN,context,LoginActivity.class);
                 break;
            case Constants.MainActivityTAG.DEVICE_INFO:
                eventMsg = event.isActionCompleted(Constants.MainActivityTAG.DEVICE_INFO,context,DeviceInfoActivity.class);
                break;
        }
        mLoginCallback.listenEvent(eventMsg);
    }


}