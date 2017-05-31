package jp.atsushitechacademy.kanamori.aisatsuapp;

import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    int hour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this);

        textView = (TextView) findViewById(R.id.textView);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button1) {
            if (hour >= 2 && hour < 10) {
                textView.setText("おはよう");
            } else if (hour >= 10 && hour < 18) {
                textView.setText("こんにちは");
            } else if (hour >= 18 || hour < 2) {
                textView.setText("こんばんは");

            }
        }

        if (v.getId() == R.id.button2) {
            showTimePickerDialog();

        }
    }


    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay,  int minute) {
                        hour = hourOfDay;
                        Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));
                    }
                },
                0,
                0,
                true);
        timePickerDialog.show();
    }
}
