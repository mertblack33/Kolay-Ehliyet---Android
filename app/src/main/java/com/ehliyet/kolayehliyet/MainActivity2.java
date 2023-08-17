package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    Button buttona,buttonb,buttonc,buttond;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        sharedPreferences = this.getSharedPreferences("com.ehliyet.kolayehliyet", MODE_PRIVATE);
        buttona = findViewById(R.id.button6);
        buttonb = findViewById(R.id.button7);
        buttonc = findViewById(R.id.button8);
        buttond = findViewById(R.id.button9);
        buttona.setTypeface(typeface);
        buttonb.setTypeface(typeface);
        buttonc.setTypeface(typeface);
        buttond.setTypeface(typeface);

        buttona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("sınıf","B").apply();
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });

        buttonb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("sınıf","B").apply();
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
                finish();

            }
        });
        buttonc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("sınıf","B").apply();
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });
        buttond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences.edit().putString("sınıf","B").apply();
                Intent intent = new Intent(MainActivity2.this,MainActivity3.class);
                startActivity(intent);
                finish();
            }
        });



    }
}