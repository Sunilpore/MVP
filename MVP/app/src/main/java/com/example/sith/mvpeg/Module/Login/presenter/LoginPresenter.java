package com.example.sith.mvpeg.Module.Login.presenter;


import com.example.sith.mvpeg.Module.DeviceInfo.model.DeviceInfoModel;
import com.example.sith.mvpeg.Module.Login.interfaces.LoginGatherInterface;
import com.example.sith.mvpeg.Module.Login.model.User;
import com.example.sith.mvpeg.Module.Login.view.ILoginViewCallBack;

public class LoginPresenter implements ILoginPresenter {

    private ILoginViewCallBack loginCallBack;
    private LoginGatherInterface.View mView;



    public LoginPresenter(ILoginViewCallBack loginView, LoginGatherInterface.View view) {
        this.loginCallBack = loginView;
        this.mView = view;
     // initPresenter();
    }

    @Override
    public void initActivityView() {
        mView.initView();
    }


    @Override
    public void onLogin(String username, String password) {

        User user = new User(username,password);
        boolean isLoginSuccess = user.isValidate();

        if(isLoginSuccess){
            loginCallBack.onLoginResult("Login success");
        }else{
            loginCallBack.onLoginResult("Something went wrong");
        }

    }

}
