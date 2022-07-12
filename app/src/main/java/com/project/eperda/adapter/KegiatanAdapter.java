package com.project.eperda.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codesgood.views.JustifiedTextView;
import com.project.eperda.R;
import com.project.eperda.model.KegiatanModel;

import java.util.ArrayList;

public class KegiatanAdapter extends RecyclerView.Adapter<KegiatanAdapter.ViewHolder> {

private final LayoutInflater layoutInflater;
private final ArrayList<KegiatanModel> data;

    public KegiatanAdapter(Context context, ArrayList<KegiatanModel> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }


    @NonNull
    @Override
    public KegiatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.content_kegiatan, parent,false);
        return new KegiatanAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KegiatanAdapter.ViewHolder holder, int position) {

        switch (position) {
            case 0:
                holder.fotoKegiatan.setImageResource(R.drawable.dump_berita);
                break;
            case 1:
                holder.fotoKegiatan.setImageResource(R.drawable.image8);
                break;
            case 2:
                holder.fotoKegiatan.setImageResource(R.drawable.image2);
                break;
            case 3:
                holder.fotoKegiatan.setImageResource(R.drawable.image3);
                break;
            case 4:
                holder.fotoKegiatan.setImageResource(R.drawable.image4);
                break;
            case 5:
                holder.fotoKegiatan.setImageResource(R.drawable.image5);
                break;
            case 6:
                holder.fotoKegiatan.setImageResource(R.drawable.image6);
                break;
            case 7:
                holder.fotoKegiatan.setImageResource(R.drawable.image7);
                break;
        }

        if (position == 8) {
            holder.fotoKegiatan.setVisibility(View.GONE);
            holder.view.setVisibility(View.VISIBLE);
            holder.play.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.VISIBLE);
        } else {
            holder.fotoKegiatan.setVisibility(View.VISIBLE);
            holder.view.setVisibility(View.GONE);
            holder.play.setVisibility(View.GONE);
            holder.textView.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView fotoKegiatan, play;
        View view;
        TextView textView;;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // variable yang udah di declare sesuai dengan id nya masing-masing

            view = itemView.findViewById(R.id.upperLine);
            play = itemView.findViewById(R.id.iv_play);
            textView = itemView.findViewById(R.id.tv_galeri_lainnya);
            fotoKegiatan = itemView.findViewById(R.id.iv_kegiatan);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }
}
