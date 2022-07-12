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
import com.project.eperda.model.BeritaModel;

import java.util.ArrayList;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final ArrayList<BeritaModel> data;

    public BeritaAdapter(Context context, ArrayList<BeritaModel> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = layoutInflater.inflate(R.layout.content_berita, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BeritaAdapter.ViewHolder holder, int position) {
        holder.titleBerita.setText(data.get(position).getJudulBerita());

        switch (position) {
            case 1:
                holder.fotoBerita.setImageResource(R.drawable.berita2);
                String titleBerita = layoutInflater.getContext().getResources().getString(R.string.berita_title_placeholder2);
                holder.titleBerita.setText(titleBerita);
                String descBerita = layoutInflater.getContext().getResources().getString(R.string.berita_desc_placeholder2);
                holder.deskripsiBerita.setText(descBerita);
                break;
            case 2:
                holder.fotoBerita.setImageResource(R.drawable.berita3);
                String titleBerita2 = layoutInflater.getContext().getResources().getString(R.string.berita_title_placeholder3);
                holder.titleBerita.setText(titleBerita2);
                String date = layoutInflater.getContext().getString(R.string.date_placeholder);
                holder.dateBerita.setText(date);
                String descBerita2 = layoutInflater.getContext().getResources().getString(R.string.berita_desc_placeholder3);
                holder.deskripsiBerita.setText(descBerita2);
                break;
        }
        if(position == 3) {
            holder.titleBerita.setVisibility(View.GONE);
            holder.deskripsiBerita.setVisibility(View.GONE);
            holder.dateBerita.setVisibility(View.GONE);
            holder.fotoBerita.setVisibility(View.GONE);
            holder.calendar.setVisibility(View.GONE);
            holder.person.setVisibility(View.GONE);
            holder.view.setVisibility(View.VISIBLE);
            holder.play.setVisibility(View.VISIBLE);
            holder.textView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleBerita, dateBerita;
        JustifiedTextView deskripsiBerita;
        ImageView fotoBerita, play, person, calendar;
        View view;
        TextView textView;;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // variable yang udah di declare sesuai dengan id nya masing-masing

            titleBerita = itemView.findViewById(R.id.tv_berita_title);
            view = itemView.findViewById(R.id.upperLine);
            play = itemView.findViewById(R.id.iv_play);
            textView = itemView.findViewById(R.id.tv_lihat_lainnya);
            fotoBerita = itemView.findViewById(R.id.iv_berita);
            dateBerita = itemView.findViewById(R.id.tv_date_created);
            deskripsiBerita = itemView.findViewById(R.id.tv_berita_desc);
            person = itemView.findViewById(R.id.iv_person);
            calendar = itemView.findViewById(R.id.iv_calendar);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }
}
