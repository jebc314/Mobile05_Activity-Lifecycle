package com.cuijeb.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {
    private Gson gson = new Gson();

    private int currentOnCreate = 0;
    private int currentOnStart = 0;
    private int currentOnResume = 0;
    private int currentOnPause = 0;
    private int currentOnStop = 0;
    private int currentOnRestart = 0;
    private int currentOnDestroy = 0;

    private Values total;

    private TextView mcurrentcreate;
    private TextView mrunningcreate;
    private TextView mcurrentstart;
    private TextView mrunningstart;
    private TextView mcurrentresume;
    private TextView mrunningresume;
    private TextView mcurrentpause;
    private TextView mrunningpause;
    private TextView mcurrentstop;
    private TextView mrunningstop;
    private TextView mcurrentrestart;
    private TextView mrunningrestart;
    private TextView mcurrentdestroy;
    private TextView mrunningdestroy;

    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;

    private Button resetCurrent;
    private Button resetRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("Values", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        mcurrentcreate = findViewById(R.id.current_create);
        mcurrentstart = findViewById(R.id.current_start);
        mcurrentresume = findViewById(R.id.current_resume);
        mcurrentpause = findViewById(R.id.current_pause);
        mcurrentstop = findViewById(R.id.current_stop);
        mcurrentrestart = findViewById(R.id.current_restart);
        mcurrentdestroy = findViewById(R.id.current_destroy);

        mrunningcreate = findViewById(R.id.running_create);
        mrunningstart = findViewById(R.id.running_start);
        mrunningresume = findViewById(R.id.running_resume);
        mrunningpause = findViewById(R.id.running_pause);
        mrunningstop = findViewById(R.id.running_stop);
        mrunningrestart = findViewById(R.id.running_restart);
        mrunningdestroy = findViewById(R.id.running_destroy);

        getIntialValues();

        resetCurrent = findViewById(R.id.reset_current);
        resetCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentOnCreate = 0;
                currentOnStart = 0;
                currentOnResume = 0;
                currentOnPause = 0;
                currentOnStop = 0;
                currentOnRestart = 0;
                currentOnDestroy = 0;
                mcurrentcreate.setText("Create: 0");
                mcurrentstart.setText("Start: 0");
                mcurrentresume.setText("Resume: 0");
                mcurrentpause.setText("Pause: 0");
                mcurrentstop.setText("Stop: 0");
                mcurrentrestart.setText("Restart: 0");
                mcurrentdestroy.setText("Destroy: 0");
            }
        });
        resetRunning = findViewById(R.id.reset_running);
        resetRunning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = new Values();
                String json = gson.toJson(total);
                editor.putString("TotalObject", json);
                editor.apply();
                mrunningcreate.setText("Create: 0");
                mrunningstart.setText("Start: 0");
                mrunningresume.setText("Resume: 0");
                mrunningpause.setText("Pause: 0");
                mrunningstop.setText("Stop: 0");
                mrunningrestart.setText("Restart: 0");
                mrunningdestroy.setText("Destroy: 0");
            }
        });

        currentOnCreate++;
        total.create++;
        mcurrentcreate.setText("Create: " + currentOnCreate);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }

    private void getIntialValues() {
        String json = sharedPreferences.getString("TotalObject", "");
        total = gson.fromJson(json, Values.class);
        if (total == null)
            total = new Values();

        mrunningcreate.setText("Create: " + total.create);
        mrunningstart.setText("Start: " + total.start);
        mrunningresume.setText("Resume: " + total.resume);
        mrunningpause.setText("Pause: " + total.pause);
        mrunningstop.setText("Stop: " + total.stop);
        mrunningrestart.setText("Restart: " + total.restart);
        mrunningdestroy.setText("Destroy: " + total.destroy);
    }

    @Override
    protected void onStart() {
        super.onStart();
        currentOnStart++;
        total.start++;
        mcurrentstart.setText("Start: " + currentOnStart);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }

    @Override
    protected void onResume() {
        super.onResume();
        currentOnResume++;
        total.resume++;
        mcurrentresume.setText("Resume: " + currentOnResume);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }

    @Override
    protected void onPause() {
        super.onPause();
        currentOnPause++;
        total.pause++;
        mcurrentpause.setText("Pause: " + currentOnPause);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }

    @Override
    protected void onStop() {
        super.onStop();
        currentOnStop++;
        total.stop++;
        mcurrentstop.setText("Stop: " + currentOnStop);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        currentOnRestart++;
        total.restart++;
        mcurrentrestart.setText("Restart: " + currentOnRestart);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        currentOnDestroy++;
        total.destroy++;
        mcurrentdestroy.setText("Destroy: " + currentOnDestroy);
        String json = gson.toJson(total);
        editor.putString("TotalObject", json);
        editor.apply();
    }
}




