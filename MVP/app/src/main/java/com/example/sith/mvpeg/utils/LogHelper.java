package com.example.sith.mvpeg.utils;

import android.content.Context;
import android.util.Log;

public class LogHelper {

    private static final String TAGData = "myTag";
    private static final String TAGContextData = "myTag_context";
    private static final String TAGError = "ErrorTag";

    public static void showLogData(String message) {
        Log.d(TAGData, message);
    }

    public static void showLogError(String message) {
        Log.d(TAGError, "Error: " + message);
    }

    public static void showContextLogData(Context context, String s) {

        Log.d(TAGContextData, String.format("%s\t%s", context.getClass().getCanonicalName(), s));
    }

}
