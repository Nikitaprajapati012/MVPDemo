package com.okason.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Calendar;

public class DemoTiming extends AppCompatActivity {
    ImageView imageView;
    TextView mTextViewGreeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // mTextViewGreeting = (TextView) findViewById(R.id.greeting_text_view);
      //  mTextViewGreeting.setText(getGreeting());
    }

    private String getGreeting() {
        int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);

        String greeting = "hi";
        if (hour > 0 && hour <= 12) {
            greeting = "Good Morning";
        } else if (hour > 12 && hour <= 18) {
            greeting = "Good Afternoon";
        } else if (hour > 18 && hour <= 21) {
            greeting = "Good Evening";
        }else if (hour > 21 && hour <= 24) {
            greeting = "Good Night";
        }
        return greeting;
    }

}

