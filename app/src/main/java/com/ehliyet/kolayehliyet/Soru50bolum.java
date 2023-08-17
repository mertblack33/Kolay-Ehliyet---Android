package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Soru50bolum extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView ism, ism1;
    String bolum;

    Button resim1,resim2,resim3;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru50bolum);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(), "fonts/Aclonica-Regular.ttf");
        sharedPreferences = this.getSharedPreferences("com.ehliyet.kolayehliyet", MODE_PRIVATE);
        bolum = sharedPreferences.getString("sec50", "yok");
        ism = findViewById(R.id.textView3);
        ism1 = findViewById(R.id.textView4);
        ism.setTypeface(typeface);
        ism1.setTypeface(typeface);
        resim1 = findViewById(R.id.button5);
        resim2 = findViewById(R.id.button10);
        resim3 = findViewById(R.id.button11);
        resimsorgu();
    }

    public void bir(View view) {
        sharedPreferences.edit().putString("secim1", bolum + "1").apply();
        Intent intent = new Intent(Soru50bolum.this, Soru50ana.class);
        startActivity(intent);


    }

    public void iki(View view) {
        sharedPreferences.edit().putString("secim1", bolum + "2").apply();
        Intent intent = new Intent(Soru50bolum.this, Soru50ana.class);
        startActivity(intent);


    }

    public void uc(View view) {
        sharedPreferences.edit().putString("secim1", bolum + "3").apply();
        Intent intent = new Intent(Soru50bolum.this, Soru50ana.class);
        startActivity(intent);


    }

    public void resimsorgu() {
        if (bolum.equals("1. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("1. BÖLÜM501s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("1. BÖLÜM502s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("1. BÖLÜM503s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("2. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("2. BÖLÜM501s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("2. BÖLÜM502s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("2. BÖLÜM503s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("3. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("3. BÖLÜM501s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("3. BÖLÜM502s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("3. BÖLÜM503s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
    }
}