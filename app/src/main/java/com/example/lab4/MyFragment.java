package com.example.lab4;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class MyFragment extends Fragment {
TextView question, time, difficulty, group;
Button yes_b, no_b;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);

        question = (TextView) v.findViewById(R.id.question);
        time = (TextView) v.findViewById(R.id.time);
        difficulty = (TextView) v.findViewById(R.id.difficulty);
        group = (TextView) v.findViewById(R.id.group);

        yes_b = (Button) v.findViewById(R.id.yes);
        no_b = (Button) v.findViewById(R.id.no);

        Bundle b3 = getArguments();
        String timer = b3.getString("time");
        String dif = b3.getString("difficulty");
        String color = b3.getString("group");
        time.append(timer);
        time.append(" секунд");
        if (dif.equals("easy")){
            difficulty.append("легкий");
        }
        else if (dif.equals("medium")){
            difficulty.append("середній");
        }
        else if (dif.equals("hard")){
            difficulty.append("тяжкий");
        }
        if (color.equals("all")){
            group.append("всі кольори");
        }
        else if (color.equals("warm")){
            group.append("тільки теплі кольори");
        }
        else if (color.equals("cool")){
            group.append("тільки холодні кольори");
        }

        yes_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (color.equals("all")){
                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("timer",timer);
                    intent.putExtra("difficulty",dif);
                    startActivity(intent);
                }
                else if (color.equals("warm")){
                    Intent intent = new Intent(getActivity(),warm.class);
                    intent.putExtra("timer",timer);
                    intent.putExtra("difficulty",dif);
                    startActivity(intent);
                }
                else if (color.equals("cool")){
                    Intent intent = new Intent(getActivity(),cold.class);
                    intent.putExtra("timer",timer);
                    intent.putExtra("difficulty",dif);
                    startActivity(intent);
                }
            }
        });

        no_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), start.class);
                startActivity(i);
            }
        });



        return v;
    }

}