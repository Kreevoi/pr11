package com.example.pr11;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class play extends AppCompatActivity implements View.OnClickListener {

    public boolean Started = false;
    public boolean Finished = false;
    Button start, drive1, drive2;
    TextView result;

    @Override
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);

        View overlay = findViewById(R.id.playlayout);
        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        start = findViewById(R.id.btnstart2);
        start.setOnClickListener(this);
        drive1 = findViewById(R.id.btnDrive1);
        drive1.setOnClickListener(this);
        drive2 = findViewById(R.id.btnDrive2);
        drive2.setOnClickListener(this);
        result = findViewById(R.id.tvResult);
    }

    @Override
    @SuppressLint("MissingInflatedId")
    public void onClick(View v) {
        if (v.getId() == R.id.btnstart2) {
            if (!Finished) {
                if (!Started) {
                    start.setBackgroundColor(Color.RED);
                    start.setText("Pause");
                    Started = true;
                } else {
                    start.setBackgroundColor(Color.GREEN);
                    start.setText("Start");
                    Started = false;
                }
            } else {
                Intent intent = new Intent(play.this, play.class);
                startActivity(intent);
            }
        }
        if (v.getId() == R.id.btnDrive1) {
            View Car = findViewById(R.id.Car1);
            if (Started && !Finished) {
                ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car.getLayoutParams();
                margin.leftMargin += 50;
                Car.requestLayout();
                if (margin.leftMargin >= 1550) {
                    result.setText("Победа 1 игрока");
                    start.setText("Again");
                    result.setTextColor(0xffe91E63);
                    Finished = true;
                    Started = false;
                }
            }
        }
        if (v.getId() == R.id.btnDrive2) {
            View Car2 = findViewById(R.id.Car2);
            if (Started && !Finished) {
                ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams) Car2.getLayoutParams();
                margin.leftMargin += 50;
                Car2.requestLayout();
                if (margin.leftMargin >= 1550) {
                    result.setText("Победа 2 игрока");
                    start.setText("Заново");
                    result.setTextColor(0xfff00000);
                    Finished = true;
                    Started = false;
                }
            }
        }
    }
}