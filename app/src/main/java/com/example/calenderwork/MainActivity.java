package com.example.calenderwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btnAddnewAlarm;
    private RecyclerView recyclerView;
    private static ArrayList<Alarm> allAlarms;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(allAlarms == null)
            allAlarms = new ArrayList<>();

        btnAddnewAlarm = (Button)findViewById(R.id.btnAddnewAlarm);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter.setAlarms(allAlarms);

        btnAddnewAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddNewAlarmActivity.class);
                startActivity(intent);
            }
        });
        try{
            Intent intent = getIntent();
            Bundle bundle = intent.getBundleExtra(getString(R.string.bundle));
            if(bundle != null) {
                int hours = bundle.getInt(getString(R.string.hours), -1);
                int min = bundle.getInt(getString(R.string.minutes), -1);
                if(hours != -1 && min != -1){
                    Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
                    alarmIntent.putExtra(AlarmClock.EXTRA_HOUR,hours);
                    alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, min);
                    alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Hello from the other site !");
                    Alarm alarm = new Alarm(hours,min,"Hello from the other site !");
                    allAlarms.add(alarm);
                    recyclerViewAdapter.setAlarms(allAlarms);
                    startActivity(alarmIntent);
                }
            }
            else
                Log.d(TAG, "onCreate: bundle is null");
        } catch (Exception e){
            Log.d(TAG, "onCreate: " + e.toString());
            e.printStackTrace();
        }
    }
}
