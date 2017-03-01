package com.github.ulfr.calllog;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.util.Log;

import com.facebook.react.bridge.*;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.*;

import javax.annotation.Nullable;

public class CallLogModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    public CallLogModule(ReactApplicationContext reactContext) {
        super(reactContext);
        final ReactApplicationContext ctx = reactContext;
    }

    @Override
    public String getName() {
        return "CallLog";
    }

    @ReactMethod
    public void getCallLog(Callback callback) {
        callback.invoke(null, this.getCallLogList());
        return 'ZZZ';
    }

    private String getCallLogList() {
        return "XXX";
//        StringBuffer stringBuffer = new StringBuffer();
//        Cursor cursor = context.getContentResolver().query(CallLog.Calls.CONTENT_URI,
//                null, null, null, CallLog.Calls.DATE + " DESC");
//        int number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
//        int type = cursor.getColumnIndex(CallLog.Calls.TYPE);
//        int date = cursor.getColumnIndex(CallLog.Calls.DATE);
//        int duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
//        while (cursor.moveToNext()) {
//            String phNumber = cursor.getString(number);
//            String callType = cursor.getString(type);
//            String callDate = cursor.getString(date);
//            Date callDayTime = new Date(Long.valueOf(callDate));
//            String callDuration = cursor.getString(duration);
//            String dir = null;
//            int dircode = Integer.parseInt(callType);
//            switch (dircode) {
//                case CallLog.Calls.OUTGOING_TYPE:
//                    dir = "OUTGOING";
//                    break;
//                case CallLog.Calls.INCOMING_TYPE:
//                    dir = "INCOMING";
//                    break;
//
//                case CallLog.Calls.MISSED_TYPE:
//                    dir = "MISSED";
//                    break;
//            }
//            stringBuffer.append("\nPhone Number:--- " + phNumber + " \nCall Type:--- "
//                    + dir + " \nCall Date:--- " + callDayTime
//                    + " \nCall duration in sec :--- " + callDuration);
//            stringBuffer.append("\n----------------------------------");
//        }
//        cursor.close();
//        return stringBuffer.toString();
    }

    @Override
    public void onHostResume() {
        final Activity activity = getCurrentActivity();
    }

    @Override
    public void onHostPause() {
        final Activity activity = getCurrentActivity();
    }

    @Override
    public void onHostDestroy() {
        final Activity activity = getCurrentActivity();
        if (activity == null) return;
    }
}
