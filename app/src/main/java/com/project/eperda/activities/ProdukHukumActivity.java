package com.project.eperda.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.ViewHolder;
import com.project.eperda.R;
import com.project.eperda.adapter.HukumProvinsiAdapter;
import com.project.eperda.model.KegiatanModel;

import java.util.ArrayList;

public class ProdukHukumActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    RecyclerView recyclerView;
    ArrayList<KegiatanModel> itemsKegiatan;
    HukumProvinsiAdapter adapter;
    MaterialCardView cardView, buttonCari;
    ImageView dismissIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produk_hukum);

        DialogPlus dialogPlus = DialogPlus.newDialog(this)
                .setContentHolder(new ViewHolder(R.layout.top_sheet_provinsi))
                .setCancelable(true)
                .setGravity(Gravity.TOP)
                .create();

        cardView = findViewById(R.id.buttonCariDokumen);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPlus.show();
            }
        });

        recyclerView = findViewById(R.id.rv_produkHukum);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getDataKegiatan();

        dismissIcon = (ImageView) dialogPlus.findViewById(R.id.iv_dismiss);
        dismissIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPlus.dismiss();
            }
        });

        buttonCari = (MaterialCardView) dialogPlus.findViewById(R.id.button_lanjut);
        buttonCari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ProdukHukumActivity.class));
                overridePendingTransition(0,0);
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.produkHukum);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.produkHukum:
                        return true;
                    case R.id.klarifikasi:
                        startActivity(new Intent(getApplicationContext(),KlarifikasiActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.media:
                        startActivity(new Intent(getApplicationContext(),MediaActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

    private void getDataKegiatan() {
        itemsKegiatan = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            KegiatanModel kegiatanModel = new KegiatanModel();
            String judul = getResources().getString(R.string.berita_title_dump);
            kegiatanModel.setFotoKegiatan(judul);
            itemsKegiatan.add(kegiatanModel);
        }

        adapter = new HukumProvinsiAdapter(getApplicationContext(), itemsKegiatan);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {

    }
}