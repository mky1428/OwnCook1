package com.mky1428.owncook1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.content.CursorLoader;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

import retrofit2.Retrofit;

public class MyRecipeActivity extends AppCompatActivity {

    EditText et_RecipeName, et_IngredientName1, et_IngredientName2, et_IngredientName3, et_IngredientName4, et_IngredientName5, et_IngredientVolume1, et_IngredientVolume2, et_IngredientVolume3, et_IngredientVolume4, et_IngredientVolume5;
    EditText et_Manual1, et_Manual2, et_Manual3, et_Manual4, et_Manual5;
    ImageView File, File1, File2, File3, File4, File5;

    String imgPath, imgPath1, imgPath2, imgPath3, imgPath4, imgPath5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recipe);

        et_RecipeName = findViewById(R.id.et_RecipeName);
        et_IngredientName1 = findViewById(R.id.et_IngredientName1);
        et_IngredientName2 = findViewById(R.id.et_IngredientName2);
        et_IngredientName3 = findViewById(R.id.et_IngredientName3);
        et_IngredientName4 = findViewById(R.id.et_IngredientName4);
        et_IngredientName5 = findViewById(R.id.et_IngredientName5);
        et_IngredientVolume1 = findViewById(R.id.et_IngredientVolume1);
        et_IngredientVolume2 = findViewById(R.id.et_IngredientVolume2);
        et_IngredientVolume3 = findViewById(R.id.et_IngredientVolume3);
        et_IngredientVolume4 = findViewById(R.id.et_IngredientVolume4);
        et_IngredientVolume5 = findViewById(R.id.et_IngredientVolume5);
        et_Manual1 = findViewById(R.id.et_Manual1);
        et_Manual2 = findViewById(R.id.et_Manual2);
        et_Manual3 = findViewById(R.id.et_Manual3);
        et_Manual4 = findViewById(R.id.et_Manual4);
        et_Manual5 = findViewById(R.id.et_Manual5);
        File = findViewById(R.id.iv_MainImage);
        File1 = findViewById(R.id.iv_ManualImage1);
        File2 = findViewById(R.id.iv_ManualImage2);
        File3 = findViewById(R.id.iv_ManualImage3);
        File4 = findViewById(R.id.iv_ManualImage4);
        File5 = findViewById(R.id.iv_ManualImage5);

    }

    public void clickSelectMainImage(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,10);
    }

    public void clickSelectManualImage1(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,20);
    }

    public void clickSelectManualImage2(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,30);
    }

    public void clickSelectManualImage3(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,40);
    }

    public void clickSelectManualImage4(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,50);
    }

    public void clickSelectManualImage5(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,60);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==10 && resultCode==RESULT_OK){
            Uri uri =data.getData();
            if (uri!=null){
                Glide.with(this).load(uri).into(File);

                imgPath = getRealPathFromUri(uri);

                //테스트용
//                new AlertDialog.Builder(this).setMessage(imgPath).show();
            }
        }

        if (requestCode==20 && resultCode==RESULT_OK){
            Uri uri1 =data.getData();
            if (uri1!=null){
                Glide.with(this).load(uri1).into(File1);

                imgPath1 = getRealPathFromUri(uri1);
            }
        }

        if (requestCode==30 && resultCode==RESULT_OK){
            Uri uri2 =data.getData();
            if (uri2!=null){
                Glide.with(this).load(uri2).into(File2);

                imgPath2 = getRealPathFromUri(uri2);
            }
        }

        if (requestCode==40 && resultCode==RESULT_OK){
            Uri uri3 =data.getData();
            if (uri3!=null){
                Glide.with(this).load(uri3).into(File3);

                imgPath3 = getRealPathFromUri(uri3);
            }
        }

        if (requestCode==50 && resultCode==RESULT_OK){
            Uri uri4 =data.getData();
            if (uri4!=null){
                Glide.with(this).load(uri4).into(File4);

                imgPath4 = getRealPathFromUri(uri4);
            }
        }

        if (requestCode==60 && resultCode==RESULT_OK){
            Uri uri5 =data.getData();
            if (uri5!=null){
                Glide.with(this).load(uri5).into(File5);

                imgPath5 = getRealPathFromUri(uri5);
            }
        }
    }

    //Uri -- > 절대경로로 바꿔서 리턴시켜주는 메소드
    String getRealPathFromUri(Uri uri){
        String[] proj= {MediaStore.Images.Media.DATA};
        CursorLoader loader= new CursorLoader(this, uri, proj, null, null, null);
        Cursor cursor= loader.loadInBackground();
        int column_index= cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String result= cursor.getString(column_index);
        cursor.close();
        return  result;
    }

    public void clickSave(View view) {
        //서버 업로드작업

        String RecipeName = et_RecipeName.getText().toString();
        String IngredientName1 = et_IngredientName1.getText().toString();
        String IngredientName2 = et_IngredientName2.getText().toString();
        String IngredientName3 = et_IngredientName3.getText().toString();
        String IngredientName4 = et_IngredientName4.getText().toString();
        String IngredientName5 = et_IngredientName5.getText().toString();
        String IngredientVolume1 = et_IngredientVolume1.getText().toString();
        String IngredientVolume2 = et_IngredientVolume2.getText().toString();
        String IngredientVolume3 = et_IngredientVolume3.getText().toString();
        String IngredientVolume4 = et_IngredientVolume4.getText().toString();
        String IngredientVolume5 = et_IngredientVolume5.getText().toString();
        String Manual1 = et_Manual1.getText().toString();
        String Manual2 = et_Manual2.getText().toString();
        String Manual3 = et_Manual3.getText().toString();
        String Manual4 = et_Manual4.getText().toString();
        String Manual5 = et_Manual5.getText().toString();

        Retrofit retrofit = RetrofitHelper.getRetrofitInstanceScalars();

        RetrofitService retrofitService = retrofit.create(RetrofitService.class);


    }
}































