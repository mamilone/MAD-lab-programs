package com.example.myapplication4mt19cs081lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText eduser,edpass;
    Button login;
    String ruser,rpass;     //indicates recieved username and password
    String euser,epass;     //indicates entered username and password

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        eduser = (EditText) findViewById(R.id.eduser);
        edpass = (EditText) findViewById(R.id.edpass);
        login = (Button) findViewById(R.id.btlogin);

        //Getting Bundles of variables from MainActivity
        Bundle extras = getIntent().getExtras();
        ruser = extras.getString("user");
        rpass = extras.getString("pass");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                euser = eduser.getText().toString();
                epass = edpass.getText().toString();

                //comparing entered credentials with registered credentials
                if( (euser.equals(ruser)) && (epass.equals(rpass)) ) {
                    Toast.makeText(MainActivity2.this, "Valid Credentials", Toast.LENGTH_SHORT).show();
                    System.out.println("Valid User and Successfull Login");
                }
                else {
                    Toast.makeText(MainActivity2.this, "Please Enter a Valid Username or Password", Toast.LENGTH_SHORT).show();
                    System.out.println("Not Successfull Login");
                }
            }
        });
    }
}