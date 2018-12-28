package com.succ7.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.succ7.servicedemo.IRemoteService.Stub;

public class MyService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        System.out.println("MyService.onBind()");
        return new MyBinder();
    }

    @Override
    public void onCreate() {
        System.out.println("MyService.onCreate()");
        super.onCreate();
    }

    class MyBinder extends Stub {

        @Override
        public String buyTiket() {
            Log.i(MyService.class.getSimpleName(), "我被远程调用啦");
            return "北京到深圳的车票";
        }

        @Override
        public String playBall() {
            Log.i(MyService.class.getSimpleName(), "我被远程调用啦");
            return "踢足球";
        }
    }
}
