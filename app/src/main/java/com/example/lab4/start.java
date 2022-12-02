package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;

public class start extends AppCompatActivity {
TextView sec, dif, color_group;
String time, how_hard, color;
Button difficulty, group;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        sec = (TextView)findViewById(R.id.textView10);
        dif = (TextView)findViewById(R.id.textView11);
        color_group = (TextView)findViewById(R.id.textView12);
        difficulty = (Button)findViewById(R.id.button8);
        group = (Button) findViewById(R.id.button9);
        registerForContextMenu(difficulty);
        addListenerOnButton();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.time_menu, menu);
        return true;
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.seconds_75:
                sec.setText("75");
                return true;
            case R.id.seconds_60:
                sec.setText("60");
                return true;
            case R.id.seconds_45:
                sec.setText("45");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.difficulty_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.easy:
                dif.setText("easy");
                return true;
            case R.id.medium:
                dif.setText("medium");
                return true;
            case R.id.hard:
                dif.setText("hard");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void addListenerOnButton() {
        Button start_btn = (Button) findViewById(R.id.button3);
        Button leave_btn = (Button) findViewById(R.id.button4);
        start_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            time = sec.getText().toString();
                            how_hard = dif.getText().toString();
                            color = color_group.getText().toString();
                            settings();
                    }
                }
        );
        leave_btn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                    }
                }
        );
        group.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Creating the instance of PopupMenu
                PopupMenu popup = new PopupMenu(start.this, group);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.color_group_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.all:
                                color_group.setText("all");
                                return true;
                            case R.id.warm:
                                color_group.setText("warm");
                                return true;
                            case R.id.cool:
                                color_group.setText("cool");
                                return true;
                            default:
                                return false;
                        }
                    }
                });

                popup.show();//showing popup menu
            }
        });

    }
    public void settings(){
        Intent intent = new Intent(this,settings.class);
        intent.putExtra("timer",time);
        intent.putExtra("difficulty",how_hard);
        intent.putExtra("group",color);
        startActivity(intent);
    }
}