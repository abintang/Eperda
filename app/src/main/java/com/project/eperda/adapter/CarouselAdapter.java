package com.project.eperda.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.project.eperda.activities.Carousel_Item;
import com.project.eperda.R;

import java.util.List;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>{

    private List<Carousel_Item> carouselItemList;
    private ViewPager2 viewPager2;

    public CarouselAdapter(List<Carousel_Item> carouselItemList, ViewPager2 viewPager2) {
        this.carouselItemList = carouselItemList;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public CarouselViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CarouselViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_bagan_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CarouselViewHolder holder, int position) {
        holder.setImageView(carouselItemList.get(position));
        if (position == carouselItemList.size() - 2) {
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return carouselItemList.size();
    }

    class CarouselViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;

        public CarouselViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_carousel_item);
        }

        public void setImageView(Carousel_Item carousel_item) {
            imageView.setImageResource(carousel_item.getImage());
        }
    }

    private  Runnable runnable = new Runnable() {
        @Override
        public void run() {
            carouselItemList.addAll(carouselItemList);
            notifyDataSetChanged();
        }
    };
}
