package com.example.sith.mvpeg.model;

import android.content.Context;
import android.content.Intent;

import com.example.sith.mvpeg.Interface.IEventListener;

public class Event implements IEventListener {

    @Override
    public String isActionCompleted(String action, Context context, Class<?> intentClass) {

        Intent i = new Intent(context,intentClass);
        context.startActivity(i);
        return action;
    }
}
