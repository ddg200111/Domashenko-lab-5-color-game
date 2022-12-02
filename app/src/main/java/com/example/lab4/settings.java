package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class settings extends AppCompatActivity {
TextView time, difficulty, color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction t = manager.beginTransaction();
        MyFragment m = new MyFragment();

        time = (TextView) findViewById(R.id.textView14);
        difficulty = (TextView) findViewById(R.id.textView13);
        color = (TextView) findViewById(R.id.textView15);
        time.setText(getIntent().getStringExtra("timer"));
        difficulty.setText(getIntent().getStringExtra("difficulty"));
        color.setText(getIntent().getStringExtra("group"));

        Bundle b2 = new Bundle();
        b2.putString("time", time.getText().toString());
        b2.putString("difficulty", difficulty.getText().toString());
        b2.putString("group", color.getText().toString());
        m.setArguments(b2);
        t.add(R.id.fram1234, m);
        t.commit();

        time.setText("");
        difficulty.setText("");
        color.setText("");

    }
}