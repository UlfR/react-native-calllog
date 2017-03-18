package com.github.ulfr.calllog;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.ContentValues;
import android.util.Log;

import com.facebook.react.bridge.*;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import java.util.*;

import javax.annotation.Nullable;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import me.everything.providers.android.calllog.Call;
import me.everything.providers.android.calllog.CallsProvider;
import me.everything.providers.core.Data;

public class CallLogModule extends ReactContextBaseJavaModule implements LifecycleEventListener {
    CallsProvider callsProvider;

    public CallLogModule(ReactApplicationContext reactContext) {
        super(reactContext);
        final ReactApplicationContext ctx = reactContext;
        callsProvider = new CallsProvider(ctx);
    }

    @Override
    public String getName() {
        return "CallLog";
    }

    @ReactMethod
    public void getCallLog(final ReadableMap options, final Promise promise) {
        promise.resolve(this.getCallLogList());
//        promise.reject("E_ACTIVITY_DOES_NOT_EXIST", "Activity doesn't exist");
    }

    private WritableArray getCallLogList() {
        List<Call> calls = callsProvider.getCalls().getList();
        WritableArray result = new WritableNativeArray();

        for (Call call : calls) {
            WritableMap mCall = new WritableNativeMap();

            mCall.putString("id", String.valueOf(call.id));
            mCall.putString("callDate", String.valueOf(call.callDate));
            mCall.putString("duration", String.valueOf(call.duration));
            mCall.putString("name", call.name);
            mCall.putString("number", call.number);
            mCall.putBoolean("isRead", call.isRead);
            mCall.putString("type", call.type != null ? call.type.toString() : "UNKNOWN");
            result.pushMap(mCall);
        }
        return result;
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
