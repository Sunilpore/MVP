package com.example.sith.mvpeg;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sith.mvpeg.Class.BaseActivity;
import com.example.sith.mvpeg.Class.LoginPresenter;
import com.example.sith.mvpeg.Interface.LoginCallback;
import com.example.sith.mvpeg.Module.Login.LoginActivity;
import com.example.sith.mvpeg.abstract_method.Creator;
import com.example.sith.mvpeg.abstract_method.Interfaces.DeviceInfoAccess;
import com.example.sith.mvpeg.abstract_method.MyAbstract;
import com.example.sith.mvpeg.utils.LogHelper;
import com.example.sith.mvpeg.utils.constants.Constants;

import java.lang.reflect.Field;

public class MainActivity <T> extends BaseActivity implements LoginCallback {

    LoginPresenter mLoginPresenter;
    Context mContext;

    EditText editView;
    TextView msg;
    Button btn, loginBut, deviceInfoBut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        editView = findViewById(R.id.input_editor_view);
        msg = findViewById(R.id.display_msg);
        btn = (Button) findViewById(R.id.set_value);

        loginBut = findViewById(R.id.login_but);
        deviceInfoBut = findViewById(R.id.device_info_but);

        mLoginPresenter = new LoginPresenter();

        btn.setOnClickListener(view -> mLoginPresenter.setMsg(true));

        loginBut.setOnClickListener(view -> mLoginPresenter.actionEvent(this,Constants.MainActivityTAG.LOGIN));

        deviceInfoBut.setOnClickListener(view -> mLoginPresenter.actionEvent(this,Constants.MainActivityTAG.DEVICE_INFO));


        mLoginPresenter.setLoginCallback(this);

    }

    @Override
    protected void init() {
        // Permission check
        //Databse initialization
        //Presenter initialization
    }


    @Override
    public void setCallback(boolean loginCallback) {

        String editMsg = editView.getText().toString();

        if(!TextUtils.isEmpty(editMsg)){
            msg.setText(editMsg);
        }

        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;

        Field[] fields = Build.VERSION_CODES.class.getFields();
        String osName = fields[Build.VERSION.SDK_INT + 1].getName();

        msg.setText("manufacturer: "+manufacturer+"\t model: "+model+"\t os: "+osName);

        MyAbstract myAbstract = Creator.getPermission("Permission");

        DeviceInfoAccess deviceInfoAccess = myAbstract.getDevicePara("AccessDeviceInfo");

        ActivityManager am = (ActivityManager) this.getSystemService(Activity.ACTIVITY_SERVICE);
        String MyClassName = am.getRunningTasks(1).get(0).topActivity.getClassName();

        LogHelper.showLogData(MyClassName);

        for(String s :deviceInfoAccess.getIMEI(this)){
            Log.d("myTag","imei: "+s);
        }

        Toast.makeText(this, "Status: " + loginCallback, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void listenEvent(String event) {

        switch (event){

            case Constants.MainActivityTAG.LOGIN:
                Toast.makeText(mContext, "Welcome to Login Screen", Toast.LENGTH_SHORT).show();
                break;
            case Constants.MainActivityTAG.DEVICE_INFO:
                Toast.makeText(mContext, "Welcome to device Information Screen", Toast.LENGTH_SHORT).show();
            break;
        }



    }


}
