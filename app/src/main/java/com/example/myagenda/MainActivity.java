package com.example.myagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWeather = findViewById(R.id.tv_main_weather);

        RequestWeatherTask requestWeatherTask = new RequestWeatherTask();

        requestWeatherTask.setWeatherListener(data -> {
            tvWeather.setText(data.getCity() + " " + data.getTemp() + "°c");
        });

        requestWeatherTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"Bruxelles, CA");
    }
}