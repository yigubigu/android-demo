package com.example.lory.learnservice;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements android.content.ServiceConnection {
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        intent = new Intent(MainActivity.this, MyService.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStartService).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                startService(intent);
            }
        });

        findViewById(R.id.btnStopService).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                stopService(intent);
            }
        });

        findViewById(R.id.btnBindService).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bindService(intent, MainActivity.this, Context.BIND_AUTO_CREATE);
            }
        });

        findViewById(R.id.btnUnbindService).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                unbindService(MainActivity.this);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        System.out.println("service connected");
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {
        System.out.println("");
    }
}
