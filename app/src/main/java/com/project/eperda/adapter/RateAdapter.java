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
import com.project.eperda.model.RateModel;

import java.util.ArrayList;

public class RateAdapter extends RecyclerView.Adapter<RateAdapter.ViewHolder> {

    private final LayoutInflater layoutInflater;
    private final ArrayList<RateModel> data;


    public RateAdapter(Context context, ArrayList<RateModel> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public RateAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.content_testimoni, parent,false);
        return new RateAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RateAdapter.ViewHolder holder, int position) {
        switch (position) {
            case 1:
                holder.fotoPerson.setImageResource(R.drawable.person2);
                String nama = layoutInflater.getContext().getResources().getString(R.string.placeholder_person2);
                holder.textView.setText(nama);
                String title = layoutInflater.getContext().getResources().getString(R.string.placeholder_title2);
                holder.titlePerson.setText(title);
                String testimoni = layoutInflater.getContext().getResources().getString(R.string.placeholder_testimoni2);
                holder.testimoni.setText(testimoni);
                break;
            case 2:
                holder.fotoPerson.setImageResource(R.drawable.person3);
                String nama2 = layoutInflater.getContext().getResources().getString(R.string.placeholder_person3);
                holder.textView.setText(nama2);
                String title2 = layoutInflater.getContext().getResources().getString(R.string.placeholder_title3);
                holder.titlePerson.setText(title2);
                String testimoni2 = layoutInflater.getContext().getResources().getString(R.string.placeholder_testimoni3);
                holder.testimoni.setText(testimoni2);
                break;
            case 3:
                holder.fotoPerson.setImageResource(R.drawable.person4);
                String nama4 = layoutInflater.getContext().getResources().getString(R.string.placeholder_person4);
                holder.textView.setText(nama4);
                String title4 = layoutInflater.getContext().getResources().getString(R.string.placeholder_title4);
                holder.titlePerson.setText(title4);
                String testimoni4 = layoutInflater.getContext().getResources().getString(R.string.placeholder_testimoni4);
                holder.testimoni.setText(testimoni4);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView, titlePerson;
        ImageView fotoPerson;
        JustifiedTextView testimoni;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // variable yang udah di declare sesuai dengan id nya masing-masing

            fotoPerson = itemView.findViewById(R.id.iv_person);
            textView = itemView.findViewById(R.id.tv_person_nama);
            testimoni = itemView.findViewById(R.id.tv_rate);
            titlePerson = itemView.findViewById(R.id.tv_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }
}
