package com.example.testealarm02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button button;
    TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        timePicker = findViewById(R.id.timePicker);
        timePicker.setIs24HourView(true);

    }

    public void adicionar(View view) {
        int hour = timePicker.getHour();
        int min = timePicker.getMinute();
        AlarmUtil.adicionarAlarm(MainActivity.this,hour,min);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AlarmUtil.cancelarAlarm(MainActivity.this);

    }
}