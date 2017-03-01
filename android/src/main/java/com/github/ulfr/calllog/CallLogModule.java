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
    public void getOrientation(Callback callback) {
        callback.invoke(null, this.getCallLog());
    }

    private String getCallLog() {
        return "XXX"
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
