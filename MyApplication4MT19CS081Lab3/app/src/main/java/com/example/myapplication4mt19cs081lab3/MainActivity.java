package com.example.myapplication4mt19cs081lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    Button b1;
    String user,pass;
    Pattern pattern;
    Matcher matcher;
    private static final String REG = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%&]).{6,20})";
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pattern = Pattern.compile(REG);
        b1 =  findViewById(R.id.bt1);
        e1 =  findViewById(R.id.ed1);
        e2 =  findViewById(R.id.ed2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent i = new Intent(MainActivity.this, MainActivity2.class);
                user = e1.getText().toString();
                pass = e2.getText().toString();
                matcher = pattern.matcher(pass);
                if(!matcher.matches()) {
                    Toast.makeText(MainActivity.this, "Please Enter a Valid Password", Toast.LENGTH_SHORT).show();
                    System.out.println("Wrong Password");
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("user",user);
                    i.putExtra("pass",pass);
                    System.out.println("Correct Password");
                    startActivity(i);
                }
                System.out.println("Entered Username : "+user);
                System.out.println("Entered Password : "+pass);
                //startActivity(i);
            }
        });

    }
}