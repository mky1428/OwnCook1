package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class RecMenuSelectActivity extends AppCompatActivity {

    //인증키 : d0dd9f7df5014307a705
    //주소 : https://openapi.foodsafetykorea.go.kr/api/d0dd9f7df5014307a705/COOKRCP01/json/1/30

    ArrayList<String> manuals = new ArrayList<>();

    ListView listView;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_menu_select);

        listView = findViewById(R.id.listview);
        adapter = new ArrayAdapter(this, R.layout.list_parse_recipe, manuals);
        listView.setAdapter(adapter);
    }

    public void clickParse(View view) {

        new Thread(){

            @Override
            public void run() {

                String urlAddress = "https://openapi.foodsafetykorea.go.kr/api/d0dd9f7df5014307a705/COOKRCP01/json/1/30";

                try {
                    URL url = new URL(urlAddress);

                    InputStream is = url.openStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader reader = new BufferedReader(isr);

                    StringBuffer buffer = new StringBuffer();
                    String line = reader.readLine();
                    while (line!=null){

                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }

        }.start();

    }

}