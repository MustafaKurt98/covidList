package com.mustafakurt.xml_design_example.adapter;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mustafakurt.xml_design_example.R;
import com.mustafakurt.xml_design_example.model.GlobalModel;

import java.util.ArrayList;

public class Adapter3 extends RecyclerView.Adapter<Adapter3.RowHolder> {
    private ArrayList<GlobalModel> globalList;
    private String[]
            colors = {"#FF7777", "#1DB9C3", "#F9D4F8", "#A2CDCD", "#FCD2D1", "#C1FFD7", "#FDB9FC", "#F3D5C0"};

    public Adapter3(ArrayList<GlobalModel> globalList) {
        this.globalList = globalList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view=layoutInflater.inflate(R.layout.row_layout1,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return globalList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView Country;
        TextView CountryCode;
        TextView TotalConfirmed;
        TextView TotalDeaths;
        TextView Date;
        TextView NewDeaths;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(GlobalModel globalModel, String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position%8]));
            Country=itemView.findViewById(R.id.countrynameText);
            CountryCode=itemView.findViewById(R.id.confirmedText);
            TotalConfirmed=itemView.findViewById(R.id.deathsText);
            TotalDeaths=itemView.findViewById(R.id.recoveredText);
            Date=itemView.findViewById(R.id.activeText);
            NewDeaths=itemView.findViewById(R.id.dateText);

            Country.setText("Ülke: "+globalModel.Country);
            CountryCode.setText("Ülke Kodu: "+globalModel.CountryCode);
            TotalConfirmed.setText("Onaylanan Vaka: "+globalModel.TotalConfirmed);
            TotalDeaths.setText("Toplam Ölüm"+globalModel.TotalDeaths);
            Date.setText("Tarih: "+globalModel.Date);
            NewDeaths.setText("Yeni Ölüm: "+globalModel.NewDeaths);
        }
    }
}
