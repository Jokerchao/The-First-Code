package com.example.servicetest;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by KingChaos on 2017/4/25.
 */

public class MyIntentService extends IntentService {

    //IntentService的特性是运行后会自动停止
    private static final String TAG="MyIntentService";

    public MyIntentService(String name) {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //打印当前线程Id
        Log.d(TAG, "onHandleIntent: Thread id is "+Thread.currentThread().getId());


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: onDestory executed");
    }
}
