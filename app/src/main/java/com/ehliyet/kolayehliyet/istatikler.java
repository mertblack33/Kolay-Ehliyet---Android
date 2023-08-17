package com.ehliyet.kolayehliyet;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

public class istatikler extends AppCompatActivity {
    TextView dogru,yanlis,toplam , genel1,genel2,genel3;

    SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_istatikler);
        Typeface typeface = Typeface.createFromAsset(this.getAssets(),"fonts/Aclonica-Regular.ttf");
        dogru = findViewById(R.id.textView12);
        yanlis = findViewById(R.id.textView14);
        toplam = findViewById(R.id.textView10);
        genel1 = findViewById(R.id.textView11);
        genel2 = findViewById(R.id.textView13);
        genel3 = findViewById(R.id.textView8);
        dogru.setTypeface(typeface);
        yanlis.setTypeface(typeface);
        toplam.setTypeface(typeface);
        genel3.setTypeface(typeface);
        genel1.setTypeface(typeface);
        genel2.setTypeface(typeface);
        database = this.openOrCreateDatabase("data", MODE_PRIVATE, null);
        Cursor cursor = database.rawQuery("SELECT * FROM A WHERE bolum='A1bölüm1'",null);
        int sayi = Integer.parseInt(String.valueOf(cursor.getColumnIndex("dogru")));
        int sayi1 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("yanlis")));
        int sayi2 = Integer.parseInt(String.valueOf(cursor.getColumnIndex("toplam")));
        while (cursor.moveToNext()) {
            dogru.setText("" + cursor.getInt(sayi));
            yanlis.setText("" + cursor.getInt(sayi1));
            toplam.setText(""+cursor.getInt(sayi2));
        }
    }
}