package com.example.sith.mvpeg.Module.Login.interfaces;

public interface LoginGatherInterface {

    interface View {
        void initView();
    }

    interface IUser {
        String getUserName();
        String getPassword();
        boolean isValidate();
    }

}
