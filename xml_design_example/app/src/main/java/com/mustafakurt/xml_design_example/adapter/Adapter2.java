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
import com.mustafakurt.xml_design_example.model.CountryModel;
import com.mustafakurt.xml_design_example.model.CovidModel;

import java.util.ArrayList;

public class Adapter2 extends RecyclerView.Adapter<Adapter2.RowHolder> {
    private ArrayList<CountryModel> countryList;
    private String[]
            colors = {"#00A19D", "#80ED99"};

    public Adapter2(ArrayList<CountryModel> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View view= layoutInflater.inflate(R.layout.row_layout2,parent,false);
        return new RowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.bind(countryList.get(position),colors,position);

    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        TextView countriesname;
        TextView slugname;
        TextView iso2;

        public RowHolder(@NonNull View itemView) {
            super(itemView);
        }

        @SuppressLint("SetTextI18n")
        public void bind(CountryModel countryModel, String[] colors, Integer position){
            itemView.setBackgroundColor(Color.parseColor(colors[position%2]));
            countriesname=itemView.findViewById(R.id.countriesnameText);
            slugname=itemView.findViewById(R.id.slugText);
            iso2=itemView.findViewById(R.id.iso2Text);

            countriesname.setText("Ülke: "+ countryModel.Countries);
            slugname.setText(countryModel.Slug);
            iso2.setText("Ülke Kodu: "+countryModel.ISO2);
        }
    }
}
