package com.example.sith.mvpeg.abstract_method.MethodClass;

import android.annotation.SuppressLint;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.example.sith.mvpeg.abstract_method.Interfaces.DeviceInfoAccess;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeviceInfo implements DeviceInfoAccess {

    private static final String DeviceInfoTAG = "DeviceInfoKey";
    String IMEI, IMEI2, IMEI3;
    HashSet<String> allIMEI;




    @SuppressLint("MissingPermission")
    @Override
    public List<String> getIMEI(Context context) {

        allIMEI = new HashSet<>();

        TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (tManager != null) {
                IMEI = tManager.getDeviceId(1);
                IMEI2 = tManager.getDeviceId(2);
                IMEI3 = tManager.getDeviceId(3);
            }


/*          IMEI = "123";
            IMEI2 = "125";
            IMEI3 = "456";*/

            allIMEI.add(IMEI);
            allIMEI.add(IMEI2);
            allIMEI.add(IMEI3);

            Log.d(DeviceInfoTAG," 1st: "+IMEI+"\t2nd: "+IMEI2+" \t3rd: "+IMEI3);

            return new ArrayList<>(allIMEI);
        }else{
            //IMEI = tManager.getDeviceId();
            IMEI = "123";
            allIMEI.add(IMEI);
            Log.d(DeviceInfoTAG,"IMEI: "+IMEI);

            return new ArrayList<>(allIMEI);
        }

    }








}
