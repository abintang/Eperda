package com.project.eperda.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.project.eperda.R;

public class MediaActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.media);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.produkHukum:
                        startActivity(new Intent(getApplicationContext(),ProdukHukumActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.klarifikasi:
                        startActivity(new Intent(getApplicationContext(),KlarifikasiActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.media:
                        return true;
                }
                return false;
            }
        });
    }
}