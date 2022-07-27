package com.example.myapplication4mt19cs081lab2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e1;
    Button b0;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button beq;
    Button badd;
    Button bsub;
    Button bdiv;
    Button bmul;
    Button bc;
    float v1,v2,res;
    boolean add=false,sub=false,mul=false,div=false;
    String r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b0=(Button)findViewById(R.id.bt0);
        b1=(Button)findViewById(R.id.bt1);
        b2=(Button)findViewById(R.id.bt2);
        b3=(Button)findViewById(R.id.bt3);
        b4=(Button)findViewById(R.id.bt4);
        b5=(Button)findViewById(R.id.bt5);
        b6=(Button)findViewById(R.id.bt6);
        b7=(Button)findViewById(R.id.bt7);
        b8=(Button)findViewById(R.id.bt8);
        b9=(Button)findViewById(R.id.bt9);
        badd=(Button)findViewById(R.id.btadd);
        bsub=(Button)findViewById(R.id.btsub);
        bmul=(Button)findViewById(R.id.btmul);
        bdiv=(Button)findViewById(R.id.btdiv);
        beq=(Button)findViewById(R.id.bteq);
        e1=(EditText)findViewById(R.id.ed1);
        bc=(Button)findViewById(R.id.btc);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("1");}
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("2");}

        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("3");}
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("4");}

        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("5");}
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("6");}

        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("7");}
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("8");}

        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("9");}
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("0");}

        });

        bc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");}

        });

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1=Float.parseFloat(String.valueOf(e1.getText()));
                add=true;
            }
        });

        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                sub = true;
            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                mul = true;
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                div = true;
            }
        });


        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v2=Float.parseFloat(String.valueOf(e1.getText()));
                if(add==true)
                {  res=v1+v2;

                    add=false;
                }
                else if(sub==true)
                {  res=v1-v2;

                    sub=false;
                }
                else if(mul==true)
                {  res=v1*v2;

                    mul=false;
                }
                else if(div==true)
                {  res=v1/v2;

                    div=false;
                }
                r= String.valueOf(res);
                e1.setText(r);
            }


        });
    }
}