package com.example.myagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import com.example.myagenda.models.WeatherData;
import com.example.myagenda.webapi.RequestWeatherTask;



public class MainActivity extends AppCompatActivity {
    TextView tvCounter, tvWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvWeather = findViewById(R.id.tv_main_weather);

        RequestWeatherTask requestWeatherTask = new RequestWeatherTask();

        requestWeatherTask.setWeatherListener(data -> {
            tvWeather.setText(data.getCity() + " " + data.getTemp() + "°c");
        });

        requestWeatherTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"Bruxelles, BE");

    }
}