package com.mustafakurt.covidlist.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafakurt.covidlist.R;
import com.mustafakurt.covidlist.model.CovidModel;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {
    private ArrayList<CovidModel> covidList;
    private String[]
            colors = {"#FF7777", "#1DB9C3", "#F9D4F8", "#A2CDCD", "#FCD2D1", "#C1FFD7", "#FDB9FC", "#F3D5C0"};

    public RecyclerViewAdapter(ArrayList<CovidModel> covidList) {
        this.covidList = covidList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.row_layout,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(covidList.get(position),colors,position);

    }

    @Override
    public int getItemCount() {
        return covidList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView countryName;
        TextView Confirmed;
        TextView Deaths;
        TextView Recovered;
        TextView active;
        TextView date;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(CovidModel covidModel, String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position%8]));
            countryName=itemView.findViewById(R.id.countrynameText);
            Confirmed=itemView.findViewById(R.id.confirmedText);
            Deaths=itemView.findViewById(R.id.deathsText);
            Recovered=itemView.findViewById(R.id.recoveredText);
            active=itemView.findViewById(R.id.activeText);
            date=itemView.findViewById(R.id.dateText);

            countryName.setText("Ülke: "+ covidModel.Country);
            Confirmed.setText("Onaylanmış Vaka:"+covidModel.Confirmed);
            Deaths.setText("Ölüm Sayısı: "+covidModel.Deaths);
            Recovered.setText("İyileşen Sayısı: "+covidModel.Recovered);
            active.setText("Aktif Vaka: "+covidModel.Active);
            date.setText("Tarih: "+covidModel.Date);
        }
    }
}
