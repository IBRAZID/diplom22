package com.example.diplom22;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.MyViewHolder>{
    Context context;
    ArrayList<Planet> PlanetList;
    private FirebaseServices fbs;

    public PlanetAdapter(Context context, ArrayList<Planet> ProductList) {
        this.context = context;
        this.PlanetList = ProductList;
        this.fbs = FirebaseServices.getInstance();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View v= LayoutInflater.from(context).inflate(R.layout.planetlayout,parent,false);
        return  new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Planet plan = PlanetList.get(position);
        holder.tvName.setText(plan.getName());
        holder.tvSize.setText(plan.getSize());
        holder.tvGalaxy.setText(plan.getGalaxy());
        holder.tvHabitable.setText(plan.getDescription());
    }

    @Override
    public int getItemCount(){
        return PlanetList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tvName;
        TextView tvSize;
        TextView tvGalaxy;
        TextView tvHabitable;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.tvNamePlanetLayout);
            tvSize=itemView.findViewById(R.id.tvSizePlanetLayout);
            tvGalaxy=itemView.findViewById(R.id.tvGalaxyPlanetLayout);
            tvHabitable=itemView.findViewById(R.id.tvDescriptionPlanetLayout);
        }
    }

}
