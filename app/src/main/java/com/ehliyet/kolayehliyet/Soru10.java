package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Soru10 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayAdapter<CharSequence> adapter;
    String bolum;
    int sayi =0;

    Button button,home;

    SharedPreferences sharedPreferences;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru10);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        sharedPreferences = this.getSharedPreferences("com.ehliyet.kolayehliyet", MODE_PRIVATE);
        Spinner spinner = findViewById(R.id.gider);
        button = findViewById(R.id.button4);
        home = findViewById(R.id.button);
        home.setTypeface(typeface);
        button.setTypeface(typeface);
        adapter = ArrayAdapter.createFromResource(this,
                R.array.kisa10, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(R.layout.sipinner_size);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Soru10.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String deger = sharedPreferences.getString("sec","yok");
                if (deger.equals("0") || deger.equals("BÖLÜM SEÇ")){
                    Toast.makeText(Soru10.this,"Lütfen Bölüm Seçiniz",Toast.LENGTH_LONG).show();
                } else{
                    Intent intent = new Intent(Soru10.this,Soru10bolum.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String sec = sharedPreferences.getString("sec","0");
        ((TextView) view).setTextColor(Color.WHITE);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        ((TextView) view).setTextSize(28);
        ((TextView) view).setTypeface(typeface);
        if (sec.contains("0") || sec.equals("BÖLÜM SEÇ") && sayi ==0){
            adapterView.setSelection(0);
        }if (sec.contains("1")&& sayi ==0){
            adapterView.setSelection(1);
        }if (sec.contains("2")&& sayi ==0){
            adapterView.setSelection(2);
        }if (sec.contains("3")&& sayi ==0){
            adapterView.setSelection(3);
        }if (sec.contains("4")&& sayi ==0){
            adapterView.setSelection(4);
        }if (sec.contains("5")&& sayi ==0){
            adapterView.setSelection(5);
        }if (sec.contains("6")&& sayi ==0){
            adapterView.setSelection(6);
        }if (sec.contains("7")&& sayi ==0){
            adapterView.setSelection(7);
        }if (sec.contains("8")&& sayi ==0){
            adapterView.setSelection(8);
        }if (sec.contains("9")&& sayi ==0){
            adapterView.setSelection(9);
        }if (sec.contains("10")&& sayi ==0){
            adapterView.setSelection(10);
        }if (sec.contains("11")&& sayi ==0){
            adapterView.setSelection(11);
        }if (sec.contains("12")&& sayi ==0){
            adapterView.setSelection(12);
        }if (sec.contains("13")&& sayi ==0){
            adapterView.setSelection(13);
        }
        sayi++;
        bolum = adapterView.getItemAtPosition(i).toString();
        sharedPreferences.edit().putString("sec",bolum).apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}