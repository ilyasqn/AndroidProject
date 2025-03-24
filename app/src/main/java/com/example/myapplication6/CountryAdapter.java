package com.example.myapplication6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.ViewHolder> {
    private final List<Country> countryList;

    public CountryAdapter(List<Country> countryList) {
        this.countryList = countryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_country, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Country country = countryList.get(position);
        holder.textViewCountry.setText(country.getName());
        holder.textViewPopulation.setText("Population: " + country.getPopulation());
        holder.imageViewFlag.setImageResource(country.getFlagResId());

        holder.itemView.setOnClickListener(v -> {
            String message = "Selected : " + country.getName() + " (Population: " + country.getPopulation() + ")";
            Toast.makeText(holder.itemView.getContext(), message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return countryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewCountry, textViewPopulation;
        ImageView imageViewFlag;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewCountry = itemView.findViewById(R.id.textViewCountry);
            textViewPopulation = itemView.findViewById(R.id.textViewPopulation);
            imageViewFlag = itemView.findViewById(R.id.imageViewFlag);
        }
    }
}

