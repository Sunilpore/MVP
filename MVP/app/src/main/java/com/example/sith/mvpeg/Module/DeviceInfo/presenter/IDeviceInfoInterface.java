package com.example.sith.mvpeg.Module.DeviceInfo.presenter;

import android.content.Context;

public interface IDeviceInfoInterface {

    void initActivityView();

    boolean askPermission(Context context);

    void askAllParam(Context context);

}
