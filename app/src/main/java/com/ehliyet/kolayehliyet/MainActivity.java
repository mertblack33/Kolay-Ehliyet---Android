package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String sinif;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("com.ehliyet.kolayehliyet", MODE_PRIVATE);
        String olusturma = sharedPreferences.getString("tekrar","0");
        sinif = sharedPreferences.getString("sınıf","yok");
        database = this.openOrCreateDatabase("data", MODE_PRIVATE, null);
        database.execSQL("CREATE TABLE IF NOT EXISTS A(bolum VARCHAR,toplam INT,dogru INT,yanlis INT)");
        if(olusturma.equals("0")){
            database.execSQL("INSERT INTO A(bolum,toplam,dogru,yanlis) VALUES ('A1bölüm1',0,0,0)");
            sharedPreferences.edit().putString("tekrar","1").apply();
        }
        new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                if (sinif.equals("yok")) {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intent);
                    finish();
                }else {
                    Intent intent = new Intent(MainActivity.this, MainActivity3.class);
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }
}