package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    String sinif;
    Button soru10,soru50,ozel,ist;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        sharedPreferences = this.getSharedPreferences("com.ehliyet.kolayehliyet", MODE_PRIVATE);
        sinif = sharedPreferences.getString("sınıf","yok");
        textView = findViewById(R.id.textView5);
        textView.setText(sinif);
        textView.setTypeface(typeface);
        soru10 = findViewById(R.id.button29);
        soru50 = findViewById(R.id.button30);
        ozel = findViewById(R.id.button31);
        ist = findViewById(R.id.button32);
        soru10.setTypeface(typeface);
        soru50.setTypeface(typeface);
        ozel.setTypeface(typeface);
        ist.setTypeface(typeface);

        soru10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,Soru10.class);
                startActivity(intent);
            }
        });

        soru50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,Soru50.class);
                startActivity(intent);
            }
        });


        ozel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity3.this, "Gecici Olarak Aktif Değildir.", Toast.LENGTH_SHORT).show();
            }
        });


        ist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this,istatikler.class);
                startActivity(intent);
            }
        });
    }
}