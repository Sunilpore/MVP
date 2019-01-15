package com.example.sith.mvpeg.Interface;

import android.app.Activity;
import android.content.Context;

public interface IEventListener {

    String isActionCompleted(String action, Context context, Class<?> intentClass);
}
