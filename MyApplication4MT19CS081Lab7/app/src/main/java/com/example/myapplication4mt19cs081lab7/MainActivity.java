package com.example.myapplication4mt19cs081lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText text_value;
    Button ttsb;
    TextToSpeech tts_obj;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_value = findViewById(R.id.text_value);
        ttsb = findViewById(R.id.text_to_speech);
        tts_obj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS) {
                    tts_obj.setLanguage(Locale.US);
                } else {
                    System.out.println("Error Starting Tts Engine");
                }
            }
        });
        ttsb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = text_value.getText().toString();
                tts_obj.speak(msg,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}