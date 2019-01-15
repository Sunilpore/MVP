package com.example.sith.mvpeg.SingltonHelper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {


    private static PreferenceHelper mInstance=null;
    private Context mContext;
    private SharedPreferences mSP;
    SharedPreferences.Editor ed;

    private static final String MyprefK = "Prefkey";
    private static final String MVPTestK = "MVPTestkey";
    private static final String MVPValueK = "MVPValuekey";



    //Private Constructor()
    private PreferenceHelper(Context context){
        mContext=context;
        mSP=mContext.getSharedPreferences(MyprefK,Context.MODE_PRIVATE);
        ed=mSP.edit();
    }

    public static PreferenceHelper getmInstance(Context context){
        if(mInstance==null){
            mInstance=new PreferenceHelper(context);
        }
        return  mInstance;
    }


    public boolean getMVPCheck() {
        return  mSP.getBoolean(MVPTestK, false);
    }

    public void setMVPCheck(boolean value) {
        ed.putBoolean(MVPTestK, value);
        ed.commit();
    }


    public int getMVPValue() {
        return  mSP.getInt(MVPValueK, 0);
    }

    public void setMVPValue(int value) {
        ed.putInt(MVPValueK, 0);
        ed.commit();
    }

}
