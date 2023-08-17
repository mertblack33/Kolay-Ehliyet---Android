package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.badge.BadgeUtils;

public class Soru10bolum extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView ism, ism1;
    String bolum;

    Button resim1,resim2,resim3;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soru10bolum);
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
        bolum = sharedPreferences.getString("sec", "yok");
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
        sharedPreferences.edit().putString("secim", bolum + "1").apply();
        Intent intent = new Intent(Soru10bolum.this, Soru10ana.class);
        startActivity(intent);


    }

    public void iki(View view) {
        sharedPreferences.edit().putString("secim", bolum + "2").apply();
        Intent intent = new Intent(Soru10bolum.this, Soru10ana.class);
        startActivity(intent);


    }

    public void uc(View view) {
        sharedPreferences.edit().putString("secim", bolum + "3").apply();
        Intent intent = new Intent(Soru10bolum.this, Soru10ana.class);
        startActivity(intent);


    }

    public void resimsorgu() {
        if (bolum.equals("1. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("1. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("1. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("1. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("2. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("2. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("2. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("2. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("3. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("3. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("3. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("3. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("4. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("4. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("4. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("4. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("5. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("5. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("5. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("5. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("6. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("6. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("6. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("6. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("7. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("7. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("7. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("7. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("8. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("8. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("8. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("8. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("9. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("9. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("9. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("9. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("10. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("10. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("10. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("10. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("11. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("11. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("11. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("11. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("12. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("12. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("12. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("12. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }
        if (bolum.equals("13. BÖLÜM")) {
            String bolum1s1yildiz = sharedPreferences.getString("13. BÖLÜM1s1yildiz", "3");
            if (bolum1s1yildiz.equals("0")) {
                resim1.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s1yildiz.equals("1")) {
                resim1.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s2yildiz = sharedPreferences.getString("13. BÖLÜM2s2yildiz", "3");
            if (bolum1s2yildiz.equals("0")) {
                resim2.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s2yildiz.equals("1")) {
                resim2.setBackgroundResource(R.drawable.goodfeedback);
            }
            String bolum1s3yildiz = sharedPreferences.getString("13. BÖLÜM3s3yildiz", "3");
            if (bolum1s3yildiz.equals("0")) {
                resim3.setBackgroundResource(R.drawable.badfeedback);
            }
            else if (bolum1s3yildiz.equals("1")) {
                resim3.setBackgroundResource(R.drawable.goodfeedback);
            }
        }

    }
}