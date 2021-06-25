package com.example.myagenda;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddNewEvent extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_event);


        Spinner spinner = findViewById(R.id.sp_add_task_category);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button selectDate = findViewById(R.id.calendar_pick);
        TextView date = findViewById(R.id.picked_date);

        selectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LocalDate today = LocalDate.now();

                DatePickerDialog datePickerDialog = new DatePickerDialog(AddNewEvent.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                LocalDate datePicked = LocalDate.of(year,month+1,day);
                                pickedDate(datePicked);

                            }
                        }, today.getYear(), today.getMonthValue() - 1, today.getDayOfMonth());
                datePickerDialog.show();
            }
        });

    }

    private void pickedDate(LocalDate date) {
        Toast.makeText(this ,"La date selectionné est "+ date.format(DateTimeFormatter.ISO_LOCAL_DATE),Toast.LENGTH_LONG).show();
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
