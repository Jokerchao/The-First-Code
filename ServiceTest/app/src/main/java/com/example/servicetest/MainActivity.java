package com.example.servicetest;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyService.DownloadBinder downloadBinder;
    private static final String TAG="MainActivity";
    private ServiceConnection connection=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder= (MyService.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_startService= (Button) findViewById(R.id.start_service);
        Button btn_stopService= (Button) findViewById(R.id.stop_service);
        Button btn_bindService= (Button) findViewById(R.id.bind_service);
        Button btn_unbindService= (Button) findViewById(R.id.unbind_service);
        Button btn_startIntentService= (Button) findViewById(R.id.start_intent_service);
        btn_startService.setOnClickListener(this);
        btn_stopService.setOnClickListener(this);
        btn_bindService.setOnClickListener(this);
        btn_unbindService.setOnClickListener(this);
        btn_startIntentService.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_service:
                Intent startIntent=new Intent(this,MyService.class);
                startService(startIntent);
                break;
            case R.id.stop_service:
                Intent stopIntent=new Intent(this,MyService.class);
                startService(stopIntent);
                break;
            case R.id.bind_service:
                Intent bindIntent=new Intent(this,MyService.class);
                bindService(bindIntent,connection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            case R.id.start_intent_service:
                Log.d(TAG,"Thread id is "+Thread.currentThread().getId());
                Intent intentService=new Intent(this,MyService.class);
                startService(intentService);
                break;
            default:
                break;
        }
    }
}
