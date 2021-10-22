package com.mky1428.owncook1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RecMenuSelectActivity extends AppCompatActivity {

    //인증키 : d0dd9f7df5014307a705
    //주소 : https://openapi.foodsafetykorea.go.kr/api/d0dd9f7df5014307a705/COOKRCP01/json/1/30

    RecyclerView recyclerView;
    ArrayList<RecyclerItem> items = new ArrayList<>();
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rec_menu_select);

        recyclerView = findViewById(R.id.RecMenuSelect_recycler);
        adapter = new MyAdapter(this, items);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();

        loadData();
    }

    void loadData(){

        //1.레트로핏 객체 생성
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://openapi.foodsafetykorea.go.kr");
        builder.addConverterFactory(ScalarsConverterFactory.create());
        Retrofit retrofit = builder.build();

        //2. 인터페이스 설계

        //3. 인터페이스 객체 생성
        RetrofitParse parse = retrofit.create(RetrofitParse.class);

        //4. 인터페이스 객체 안에 있는 기능메소드 호출
        Call<String> call = parse.loadRecipeData("1", "30");

        //5. 네트워크 작업 시작
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String aaa = response.body();
//                Toast.makeText(RecMenuSelectActivity.this, aaa+"", Toast.LENGTH_SHORT).show();
                try {
                    JSONObject jsonObject = new JSONObject(aaa);
                    JSONObject jsonObject1 = jsonObject.getJSONObject("COOKRCP01");
                    JSONArray rows = jsonObject1.getJSONArray("row");
//                    Toast.makeText(RecMenuSelectActivity.this, ""+rows.length(), Toast.LENGTH_SHORT).show();

                    for (int i=0; i<rows.length(); i++){

                        JSONObject jo = rows.getJSONObject(i);

                        String ATT_FILE_NO_MAIN = jo.getString("ATT_FILE_NO_MAIN");
                        String RCP_NM = jo.getString("RCP_NM");
                        String RCP_PARTS_DTLS = jo.getString("RCP_PARTS_DTLS");
                        StringBuffer buffer = new StringBuffer();
                        for (int k=1; k<21; k++){
                            String s = String.format("%02d", k);
                            String key = "MANUAL"+s;
                            String kkk = jo.getString(key);
                            if (kkk.equals("")) break;
                            buffer.append(kkk+"\n");
                        }
                        String MANUAL = buffer.toString();
//                        Toast.makeText(RecMenuSelectActivity.this, MANUAL, Toast.LENGTH_SHORT).show();
                        RecyclerItem item = new RecyclerItem(ATT_FILE_NO_MAIN, RCP_NM, RCP_PARTS_DTLS, MANUAL);
                        items.add(item);

                        adapter.notifyItemInserted(items.size()-1);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RecMenuSelectActivity.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(RecMenuSelectActivity.this, "에러 발생", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
























