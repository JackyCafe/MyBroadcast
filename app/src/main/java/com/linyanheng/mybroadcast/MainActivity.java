package com.linyanheng.mybroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final static String BROADCAST_ACTION= "Jacky" ;
    private MyReceiver receiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerMyReceiver();
    }

    private void registerMyReceiver() {
        IntentFilter filter = new IntentFilter(BROADCAST_ACTION);
        receiver = new MyReceiver();
        registerReceiver(receiver,filter);
        showToast("register Filter");


    }





    public  void showToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    public void onSendClick(View view) {
        Intent intent = new Intent(BROADCAST_ACTION);
        sendBroadcast(intent);
        showToast("Send BroadCast");

    }

    public void onCancelClick(View view) {
        unregisterReceiver(receiver);
        showToast("Cancel Register");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        showToast("Cancel Register");
    }

    class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            showToast("Broadcast Receiver");
        }
    }
}


