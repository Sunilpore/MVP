package com.example.sith.mvpeg.abstract_method;


import com.example.sith.mvpeg.abstract_method.Interfaces.DeviceInfoAccess;
import com.example.sith.mvpeg.abstract_method.MethodClass.DeviceInfo;

public class AssignClass extends MyAbstract {

    @Override
    public DeviceInfoAccess getDevicePara(String request) {

        if(request==null){
            return null;
        }

        if(request.equalsIgnoreCase("AccessDeviceInfo")){
            return new DeviceInfo();
        }

        return null;
    }

}
