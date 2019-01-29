package com.example.sith.mvpeg.Module.Login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sith.mvpeg.Class.BaseActivity;
import com.example.sith.mvpeg.Module.Login.interfaces.LoginGatherInterface;
import com.example.sith.mvpeg.Module.Login.presenter.ILoginPresenter;
import com.example.sith.mvpeg.Module.Login.presenter.LoginPresenter;
import com.example.sith.mvpeg.Module.Login.view.ILoginViewCallBack;
import com.example.sith.mvpeg.R;
import com.example.sith.mvpeg.utils.LogHelper;

public class LoginActivity extends BaseActivity implements ILoginViewCallBack,LoginGatherInterface.View {

    EditText userName,password;
    Button submit;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        LogHelper.showLogData("LoginActivity Oncreate");

        loginPresenter.initActivityView();

    }



    @Override
    protected void init() {
        //This method will run before LoginActivity onCreate();

        //Initialize Presenter
        LogHelper.showLogData("Initialize BaseActivity overide method");
        loginPresenter = new LoginPresenter(this,this);

    }



    @Override
    public void onLoginResult(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    //Initialize View Via Presenter object
    @Override
    public void initView() {

        userName = findViewById(R.id.username_view);
        password = findViewById(R.id.password_view);
        submit = findViewById(R.id.submit_but);

        submit.setOnClickListener(v->{
            String uname = userName.getText().toString();
            String upass = password.getText().toString();
            loginPresenter.onLogin(uname,upass);
        });
    }


}
