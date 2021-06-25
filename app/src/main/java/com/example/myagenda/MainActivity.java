package com.example.myagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myagenda.webapi.RequestWeatherTask;




public class MainActivity extends AppCompatActivity {
    TextView  tvWeather;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        AddNewEvent addNewEvent = new AddNewEvent();
        RecyclerView lvTasks;
        Button btnadd = (Button) findViewById(R.id.btn_add_task_valid) ;
        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddNewEvent();
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

    private void openAddNewEvent() {
        Intent intentAddNewEvent = new Intent(getApplicationContext(),AddNewEvent.class);
        startActivity(intentAddNewEvent);
    }
}