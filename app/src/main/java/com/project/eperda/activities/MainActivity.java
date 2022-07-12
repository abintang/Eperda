package com.project.eperda.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.project.eperda.R;
import com.project.eperda.adapter.BeritaAdapter;
import com.project.eperda.adapter.CarouselAdapter;
import com.project.eperda.adapter.KegiatanAdapter;
import com.project.eperda.adapter.RateAdapter;
import com.project.eperda.adapter.SliderAdapter;
import com.project.eperda.model.BeritaModel;
import com.project.eperda.model.KegiatanModel;
import com.project.eperda.model.RateModel;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    SliderView sliderView;
    int[] banners = {
            R.drawable.page1,
            R.drawable.page2,
            R.drawable.page3
    };

    ViewPager2 viewPager2;
    Handler handler = new Handler();
    RecyclerView recyclerView, recyclerView2, recyclerView3;
    ArrayList<BeritaModel> items;
    ArrayList<KegiatanModel> itemsKegiatan;
    ArrayList<RateModel> itemsRate;
    KegiatanAdapter kegiatanAdapter;
    BeritaAdapter beritaAdapter;
    RateAdapter rateAdapter;
    ImageView video;
    BottomNavigationView bottomNavigationView;
    ExtendedFloatingActionButton livechatButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderView = findViewById(R.id.imageSlider);
        SliderAdapter sliderAdapter = new SliderAdapter(banners);
        // Component Image Slider pada Dashboard
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        recyclerView = findViewById(R.id.rv_berita);
        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(horizontalLayoutManager);
        getData();

        recyclerView2 = findViewById(R.id.rv_kegiatan);
        LinearLayoutManager horizontalLayoutManager2
                = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView2.setLayoutManager(horizontalLayoutManager2);
        getDataKegiatan();

        recyclerView3 = findViewById(R.id.rv_testimoni);
        LinearLayoutManager horizontalLayoutManager3
                = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recyclerView3.setLayoutManager(horizontalLayoutManager3);
        getDataTestimoni();

        livechatButton = findViewById(R.id.liveChatButton);

        livechatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LiveChatActivity.class);
                startActivity(intent);
            }
        });

        video = findViewById(R.id.iv_video);

        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/d9B7fH7DnwI")));
            }
        });

        bottomNavigationView = findViewById(R.id.bottomNav);
        bottomNavigationView.setSelectedItemId(R.id.beranda);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.beranda:
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
                        startActivity(new Intent(getApplicationContext(),MediaActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

        viewPager2 = findViewById(R.id.baganPager);

        List<Carousel_Item> carouselItems = new ArrayList<>();
        carouselItems.add(new Carousel_Item(R.drawable.item1));
        carouselItems.add(new Carousel_Item(R.drawable.item2));
        carouselItems.add(new Carousel_Item(R.drawable.item3));

        viewPager2.setAdapter(new CarouselAdapter(carouselItems, viewPager2));
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                handler.removeCallbacks(carouselRunnable);
                handler.postDelayed(carouselRunnable, 180000);
            }
        });
    }

    private Runnable carouselRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(carouselRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(carouselRunnable, 180000);
    }

    private void getData() {
        items = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            BeritaModel beritaModel = new BeritaModel();
            String judul = getResources().getString(R.string.berita_title_dump);
            beritaModel.setJudulBerita(judul);
            items.add(beritaModel);
        }

        beritaAdapter = new BeritaAdapter(getApplicationContext(), items);
        recyclerView.setAdapter(beritaAdapter);
    }

    private void getDataKegiatan() {
        itemsKegiatan = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            KegiatanModel kegiatanModel = new KegiatanModel();
            String judul = getResources().getString(R.string.berita_title_dump);
            kegiatanModel.setFotoKegiatan(judul);
            itemsKegiatan.add(kegiatanModel);
        }

        kegiatanAdapter = new KegiatanAdapter(getApplicationContext(), itemsKegiatan);
        recyclerView2.setAdapter(kegiatanAdapter);
    }

    private void getDataTestimoni() {
        itemsRate = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            RateModel rateModel = new RateModel();
            String judul = getResources().getString(R.string.berita_title_dump);
            rateModel.setNama(judul);
            itemsRate.add(rateModel);
        }

        rateAdapter = new RateAdapter(getApplicationContext(), itemsRate);
        recyclerView3.setAdapter(rateAdapter);
    }
}