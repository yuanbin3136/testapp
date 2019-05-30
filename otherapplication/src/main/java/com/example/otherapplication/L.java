package com.example.otherapplication;

import android.util.Log;

public class L {
    static final String TAG = "wind";

    public static void o(Object o){
        Log.d(TAG ,getTrace() + o.toString());
    }//+ getTrace()

    private static String getTrace() {
        try {
            Throwable t = new Throwable();
            StackTraceElement trace = t.getStackTrace()[2];
            String method = trace.getClassName() + "." + trace.getMethodName()
                    + "[" + trace.getLineNumber() + "]line\n";
            return method;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
