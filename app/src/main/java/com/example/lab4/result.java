package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class result extends AppCompatActivity {

    Button again, exit;
    TextView result, points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        again=findViewById(R.id.button5);
        exit=findViewById(R.id.button6);
        result=findViewById(R.id.textView6);
        points=findViewById(R.id.textView7);
        addListenerOnButton();
        points.setText(getIntent().getStringExtra("key"));
    }

    void addListenerOnButton(){
        again.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(result.this, MainActivity.class);
                        finish();
                        startActivity(intent);
                    }
                }
        );
        exit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(result.this, start.class);
                        finish();
                        startActivity(intent);
                    }
                }
        );
    }

}