package com.example.sith.mvpeg.Module.DeviceInfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.sith.mvpeg.Module.DeviceInfo.interfaces.DeviceInfoBaseInterface;
import com.example.sith.mvpeg.Module.DeviceInfo.model.DeviceInfoModel;
import com.example.sith.mvpeg.Module.DeviceInfo.presenter.DeviceInfoPresenter;
import com.example.sith.mvpeg.Module.DeviceInfo.presenter.IDeviceInfoInterface;
import com.example.sith.mvpeg.Module.DeviceInfo.view.IDeviceInfoViewCallBack;
import com.example.sith.mvpeg.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DeviceInfoActivity extends DeviceBaseActivity implements IDeviceInfoViewCallBack, DeviceInfoBaseInterface.View {


   // @BindView(R.id.device_manufacturer_details)
    TextView manufacturer;

   // @BindView(R.id.device_model_details)
    TextView modelName;

   // @BindView(R.id.device_os_details)
    TextView osName;

   // @BindView(R.id.device_imeis_details)
    TextView imeiList;

   // @BindView(R.id.device_param_button)
    Button paramBut;

    IDeviceInfoInterface devicePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);

        ButterKnife.bind(mActivity);

        devicePresenter.askPermission(mContext);

        devicePresenter.initActivityView();
    }

    @Override
    protected void init() {
        super.init();
        devicePresenter = new DeviceInfoPresenter(this,this);
    }

   /* @OnClick(R.id.device_param_button)
    void onClick(View view){

        switch (view.getId()){

            case R.id.device_param_button:
                if(devicePresenter.askPermission(mContext)){
                    devicePresenter.askAllParam(mContext);
                }
                break;
        }

    }*/


    @Override
    public void initView() {

        manufacturer = findViewById(R.id.device_manufacturer_details);
        modelName = findViewById(R.id.device_model_details);
        osName = findViewById(R.id.device_os_details);
        imeiList = findViewById(R.id.device_imeis_details);
        paramBut =findViewById(R.id.device_param_button);

        paramBut.setOnClickListener(v->{
            if(devicePresenter.askPermission(mContext)){
                devicePresenter.askAllParam(mContext);
            }
        });

    }


    @Override
    public void getAllDeviceParameter(DeviceInfoModel deviceInfoModel) {

        manufacturer.setText(deviceInfoModel.getDeviceMaufacturer());
        modelName.setText(deviceInfoModel.getModelName());
        osName.setText(deviceInfoModel.getOSName());

        String imei="";
        for(String n: deviceInfoModel.getImeis())
        {
            imei = imei+" \n"+n;
        }
        imeiList.setText(imei);
    }


}
