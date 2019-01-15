package com.example.sith.mvpeg.Module.DeviceInfo.model;

import com.example.sith.mvpeg.Module.DeviceInfo.interfaces.DeviceInfoBaseInterface;

import java.util.List;

public class DeviceInfoModel implements DeviceInfoBaseInterface.IDeviceInfo {

    private String deviceMaufacturer;
    private String modelName;
    private String OSName;

    private List <String> imeis;

    public DeviceInfoModel(String manufacturer, String model, String osName, List<String> imeis) {
        deviceMaufacturer = manufacturer;
        modelName = model;
        OSName = osName;
        this.imeis = imeis;
    }


    @Override
    public String getDeviceMaufacturer() {
        return deviceMaufacturer;
    }

    @Override
    public String getModelName() {
        return modelName;
    }

    @Override
    public String getOSName() {
        return OSName;
    }

    @Override
    public List<String> getImeis() {
        return imeis;
    }

}
