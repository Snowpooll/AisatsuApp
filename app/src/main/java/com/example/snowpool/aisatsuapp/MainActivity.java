package com.example.snowpool.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView timeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button timeButton =(Button)findViewById(R.id.timepicker);
        timeButton.setOnClickListener(this);

        timeText =(TextView)findViewById(R.id.timeText);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.timepicker){
            showTimePickerDialog();
        }
    }

    private void showTimePickerDialog(){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hour, int min) {
                        if(hour >= 2 && hour <10){
                            timeText.setText("おはよう");
                        }else if(hour >= 10 && hour <17){
                            timeText.setText("こんにちわ");
                        }else {
                            timeText.setText("こんばんわ");
                        }
                    }
                },0,30,true);
        timePickerDialog.show();
    }
}
