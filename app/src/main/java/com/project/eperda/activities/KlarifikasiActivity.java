package com.project.eperda.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.cazaea.sweetalert.SweetAlertDialog;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.card.MaterialCardView;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.OnClickListener;
import com.orhanobut.dialogplus.ViewHolder;
import com.project.eperda.R;

public class KlarifikasiActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    MaterialCardView klarifikasiButton, submitButton;
    ImageView dismissIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_klarifikasi);

        klarifikasiButton = findViewById(R.id.buttonCariKlarifikasi);

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.klarifikasi);
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
                        return true;
                    case R.id.media:
                        startActivity(new Intent(getApplicationContext(),MediaActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        DialogPlus dialogPlus = DialogPlus.newDialog(this)
                .setContentHolder(new ViewHolder(R.layout.top_sheet_klarifikasi))
                .setCancelable(false)
                .setGravity(Gravity.TOP)
                .create();

        klarifikasiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPlus.show();
            }
        });



        dismissIcon = (ImageView) dialogPlus.findViewById(R.id.iv_dismiss);
        dismissIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogPlus.dismiss();
            }
        });

        submitButton = (MaterialCardView) dialogPlus.findViewById(R.id.button_lanjut);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SweetAlertDialog sweetAlertDialog =new SweetAlertDialog(view.getContext(), SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Submit Berhasil");
                sweetAlertDialog.show();
                /*if(sweetAlertDialog.isShowing()) {
                    startActivity(new Intent(getApplicationContext(),KlarifikasiActivity.class));
                    overridePendingTransition(0,0);
                }*/
            }
        });




    }

    @Override
    public void onBackPressed() {
    }
}