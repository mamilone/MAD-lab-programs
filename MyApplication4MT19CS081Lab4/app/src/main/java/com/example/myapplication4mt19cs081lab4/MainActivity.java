package com.example.myapplication4mt19cs081lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    WallpaperManager wallpaperManager;
    Button setb;
    Handler handler = new Handler();
    Integer loopv = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        setb = findViewById(R.id.button);

        setb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handler.postDelayed(runnable, 5000);
            }
        });
    }

    private final Runnable runnable = new Runnable() {
        @SuppressLint("ResourceType")
        @Override
        public void run() {
            if(loopv==1) {
                try {
                    wallpaperManager.setResource(R.drawable.b);
                } catch(IOException e) {
                    e.printStackTrace();
                }
                loopv = 2;
            }
            else if(loopv==2) {
                try {
                    wallpaperManager.setResource(R.drawable.c);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                loopv = 1;
            }
//            else if(loopv==3) {
//                try {
//                    wallpaperManager.setResource(R.drawable.d);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                loopv = 1;
//            }
            handler.postDelayed(runnable, 5000);
        }
    };
}