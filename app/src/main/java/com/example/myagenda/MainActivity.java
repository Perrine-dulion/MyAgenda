package com.example.myagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myagenda.models.WeatherData;
import com.example.myagenda.webapi.RequestWeatherTask;
import com.example.myagenda.AddNewEvent;




public class MainActivity extends AppCompatActivity {
    TextView  tvWeather;
    private Object AddNewEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//TODO click vers new event //
        //chregneugneucamarchepas voir cours/ forum//


        AddNewEvent addNewEvent = new AddNewEvent();
        RecyclerView lvTasks;
        Button btnadd = (Button) findViewById(R.id.btn_add_task_valid) ;
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { }

            private void openAddNewEvent() {openAddNewEvent();
            }
        });


        tvWeather = findViewById(R.id.tv_main_weather);

        RequestWeatherTask requestWeatherTask = new RequestWeatherTask();

        requestWeatherTask.setWeatherListener(data -> {
            tvWeather.setText(data.getCity() + " " + data.getTemp() + "°c");
        });

        requestWeatherTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,"Bruxelles, BE");
        //TODO grid pour card past event //


    }
}