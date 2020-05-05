package com.example.anlaba5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class NewTask extends AppCompatActivity {


    Calendar dateAndTime=Calendar.getInstance();
    String[] prioritet = {"Very low", "Low", "Medium", "High", " Very high"};
    int my;
    Button data, time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        data =(Button)findViewById(R.id.dateButton);
        time=(Button)findViewById(R.id.timeButton);

        // адаптер для выпадающего списка приоритетов
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, prioritet);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinner.setPrompt("Priority");
        spinner.setSelection(2);
        // утановка обработчика нажатия
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                // отображение приоритета задачи
                Toast.makeText(getBaseContext(), "Приоритет задачи " + prioritet[position] , Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }

    // диалоговоое окно выббора даты
    public void setDate(View v) {
        new DatePickerDialog(NewTask.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();

    }

    // выбор времени
    public void setTime(View v) {
        new TimePickerDialog(NewTask.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }

    //обработчик выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            ((Button)findViewById(R.id.timeButton)).setText("Время: "+hourOfDay+" "+minute);
        }
    };

    //обработчик выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            ((Button)findViewById(R.id.dateButton)).setText("Дата: "+year+" "+monthOfYear+" "+dayOfMonth);
        }

    };
    //сохранение нового и отредактированного таска
    public void save(View v) {
        String title = ((EditText) findViewById(R.id.editText)).getText().toString();
        String desc = ((EditText) findViewById(R.id.editText2)).getText().toString();
        Task t = new Task(title, desc, dateAndTime, my);
        MainActivity.task.add(t);
        MainActivity.adapter.notifyDataSetChanged();
        finish();
    }



}
