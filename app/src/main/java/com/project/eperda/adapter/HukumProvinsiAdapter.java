package com.project.eperda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.project.eperda.R;
import com.project.eperda.model.KegiatanModel;

import java.util.ArrayList;

public class HukumProvinsiAdapter extends RecyclerView.Adapter<HukumProvinsiAdapter.ViewHolder> {
    private final LayoutInflater layoutInflater;
    private final ArrayList<KegiatanModel> data;

    public HukumProvinsiAdapter(Context context, ArrayList<KegiatanModel> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public HukumProvinsiAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.content_produk_hukum, parent,false);
        return new HukumProvinsiAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HukumProvinsiAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // variable yang udah di declare sesuai dengan id nya masing-masing

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

}
