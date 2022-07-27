package com.example.myapplication4mt19cs081lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    TextView json_contents;
    TextView xml_contents;
    Button bjson,bxml;
    String cname,lat,longit,temp,hum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        json_contents = findViewById(R.id.json_contents);
        xml_contents = findViewById(R.id.xml_contents);
        bjson = findViewById(R.id.bjson);
        bxml = findViewById(R.id.bxml);

        bjson.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    InputStream inst = getAssets().open("test.json");
                    byte[] buffer = new byte[inst.available()];
                    inst.read(buffer);
                    String jsonString = new String(buffer);
                    JSONObject reader = new JSONObject(jsonString);
                    JSONObject user = reader.getJSONObject("User");
                    cname = user.getString("City_Name");
                    lat = user.getString("Latitude");
                    longit = user.getString("Longitude");
                    temp = user.getString("Temperature");
                    hum = user.getString("Humidity");
                    json_contents.setText("City_Name : "+cname+"\nLatitude : "+lat+"\nLongitude : "+longit+"\nTemperature : "+temp+"\nHumidity : "+hum);
                    System.out.println("Hio");
                    inst.close();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });

        bxml.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                try {
                    InputStream is = getAssets().open("city.xml");
                    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                    Document doc = dBuilder.parse(is);
                    NodeList nList = doc.getElementsByTagName("cities");
                    System.out.println(nList.item(0).getNodeName());
                    for(int i = 0 ; i < nList.getLength() ; i++ ) {
                        Element element2 = (Element) nList.item(i);
                        cname = element2.getElementsByTagName("cname").item(0).getFirstChild().getNodeValue();
                        lat = element2.getElementsByTagName("latitude").item(0).getFirstChild().getNodeValue();
                        longit = element2.getElementsByTagName("longitude").item(0).getFirstChild().getNodeValue();
                        temp = element2.getElementsByTagName("temp").item(0).getFirstChild().getNodeValue();
                        hum = element2.getElementsByTagName("humidity").item(0).getFirstChild().getNodeValue();
                        xml_contents.setText("City_Name : "+cname+"\nLatitude : "+lat+"\nLongitude : "+longit+"\nTemperature : "+temp+"\nHumidity : "+hum);
                    }
                    is.close();
                } catch (IOException | ParserConfigurationException | SAXException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}