package com.example.sith.mvpeg.Module.DeviceInfo.presenter;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

import com.example.sith.mvpeg.Module.DeviceInfo.DeviceInfoActivity;
import com.example.sith.mvpeg.Module.DeviceInfo.interfaces.DeviceInfoBaseInterface;
import com.example.sith.mvpeg.Module.DeviceInfo.model.DeviceInfoModel;
import com.example.sith.mvpeg.Module.DeviceInfo.view.IDeviceInfoViewCallBack;
import com.example.sith.mvpeg.abstract_method.Creator;
import com.example.sith.mvpeg.abstract_method.Interfaces.DeviceInfoAccess;
import com.example.sith.mvpeg.abstract_method.MyAbstract;
import com.example.sith.mvpeg.utils.constants.Constants;
import com.example.sith.mvpeg.utils.permission.PermissionUtils;

import java.lang.reflect.Field;
import java.util.List;

public class DeviceInfoPresenter implements IDeviceInfoInterface{

    IDeviceInfoViewCallBack deviceInfoViewCallBack;
    DeviceInfoBaseInterface.View mView;

    public DeviceInfoPresenter(DeviceInfoActivity deviceInfoActivity, DeviceInfoBaseInterface.View view) {
        this.deviceInfoViewCallBack = deviceInfoActivity;
        this.mView = view;
    }


    @Override
    public void initActivityView() {
        mView.initView();
    }


    @Override
    public boolean askPermission(Context context) {

        if(!PermissionUtils.checkPermissions(context,Manifest.permission.READ_PHONE_STATE)){
            PermissionUtils.requestPermissions(context,Constants.DeviceInfoActivityTAG.PHONE_STATE,Manifest.permission.READ_PHONE_STATE);
            return false;
        } else{
            return true;
        }

    }


    @Override
    public void askAllParam(Context context) {

        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        Field[] fields = Build.VERSION_CODES.class.getFields();
        String osName = fields[Build.VERSION.SDK_INT + 1].getName();

        MyAbstract myAbstract = Creator.getPermission("Permission");

        DeviceInfoAccess deviceInfoAccess = myAbstract.getDevicePara("AccessDeviceInfo");

        List <String> imeis = deviceInfoAccess.getIMEI(context);

        DeviceInfoModel deviceInfoModel = new DeviceInfoModel(manufacturer,model,osName,imeis);

        deviceInfoViewCallBack.getAllDeviceParameter(deviceInfoModel);
    }



}
