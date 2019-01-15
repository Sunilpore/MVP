package com.example.sith.mvpeg.Interface;

import android.content.Context;

/**
 * Created by Sunil on 1/29/2018.
 */

public interface Presenter {


    void setMsg(boolean s);

    void actionEvent(Context context, String eventMsg);

}
