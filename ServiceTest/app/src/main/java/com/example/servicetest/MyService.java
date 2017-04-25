package com.example.servicetest;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class MyService extends Service {
    private  static final String TAG="MyService";
    private DownloadBinder mBinder=new DownloadBinder();

    class DownloadBinder extends Binder {
        public void startDownload(){
            Log.d(TAG, "startDownload: startDownload excuted");
        }
        public int getProgress(){
            Log.d(TAG, "getProgress: getProgress executed");
            return 0;
        }
    }
    public MyService() {
    }

    @Override
    //服务创建时执行
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: excuted ");
        Intent intent=new Intent(this,MainActivity.class);
        PendingIntent pi=PendingIntent.getActivity(this,0,intent,0);
        Notification notification=new NotificationCompat.Builder(this)
                .setContentTitle("震惊！男人看了沉默女人看了流泪。。。")
                .setContentText("广东工业大学竟然发生了这样的事情，百分之九十的人都不知道")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher))
                .setContentIntent(pi)
                .build();
        startForeground(1,notification);
    }

    @Override

    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }
    

    @Override
    //服务启动时执行
    public int onStartCommand(Intent intent,int flags, int startId) {
        Log.d(TAG, "onStartCommand: excuted");
        //这种后台服务一旦启动就一直出于运行状态，除非调用stopServic()或者stopSelf()方法才能让它停下来
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
        return super.onStartCommand(intent, flags, startId);
    }
    
    

    @Override
    //服务销毁时执行
    public void onDestroy() {
        Log.d(TAG, "onDestroy: excuted");
        super.onDestroy();
    }
}
