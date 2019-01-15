package com.example.sith.mvpeg.Module.Login.model;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.sith.mvpeg.Module.Login.interfaces.LoginGatherInterface;

import java.util.regex.Pattern;

public class User implements LoginGatherInterface.IUser{

    String usrname,password;

    public User(String usrname, String password) {
        this.usrname = usrname;
        this.password = password;
    }

    @Override
    public String getUserName() {
        return usrname;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isValidate() {

        return !TextUtils.isEmpty(getUserName()) &&
                Patterns.EMAIL_ADDRESS.matcher(getUserName()).matches() &&
                getPassword().length()>3;
    }

}
