package com.example.sith.mvpeg.Module.DeviceInfo.interfaces;

import java.util.List;

public interface DeviceInfoBaseInterface {

    interface View {
        void initView();
    }

    interface IDeviceInfo {

        String getDeviceMaufacturer();
        String getModelName();
        String getOSName();
        List<String> getImeis();
     }


}
