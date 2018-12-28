package com.succ7.otherappservicedemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Toast;

import com.succ7.servicedemo.IRemoteService;
import com.succ7.servicedemo.IRemoteService.Stub;

public class MainActivity extends Activity {

    private ServiceConnection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 绑定服务
     * 如果不设置setPackage会报错: Service Intent must be explicit: Intent { act=x
     * 解决方案博客:https://www.aliyun.com/jiaocheng/41873.html
     */
    public void bindService(View v) {
        Intent service = new Intent("com.succ7.buytiketservice");
        //这个包名在4.4版本之后一定要设置,否则会绑定失败
        service.setPackage("com.succ7.servicedemo");
        conn = new MyServiceConnection();
        bindService(service, conn, BIND_AUTO_CREATE);
    }

    /**
     * 解绑服务
     */
    public void unBindService(View v) {
        try {
            unbindService(conn);
        } catch (Exception e) {
            Toast.makeText(this, "请先绑定远程服务", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * 调用远程服务中的方法
     */
    public void callRemoteMethod(View v) {
        try {
            String tiket = asInterface.buyTiket();
            String ball = asInterface.playBall();
            Toast.makeText(this, tiket + ":" + ball, Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            Toast.makeText(this, "请先绑定远程服务", Toast.LENGTH_LONG).show();
        }
    }

    private IRemoteService asInterface;

    class MyServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            asInterface = Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }
}
