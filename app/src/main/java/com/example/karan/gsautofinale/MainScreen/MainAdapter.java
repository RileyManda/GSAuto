package com.example.karan.gsautofinale.MainScreen;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.karan.gsautofinale.Products.Casted.CastedActivity;
import com.example.karan.gsautofinale.Products.Casted.CastedRingsActivity;
import com.example.karan.gsautofinale.Products.HubBoltWashers.HubWashersActivity;
import com.example.karan.gsautofinale.Products.HubBolts.HubboltsActivity;
import com.example.karan.gsautofinale.Products.MiscBolts.MiscBoltsActivity;
import com.example.karan.gsautofinale.Products.CheckNuts.CheckNutsActivity;
import com.example.karan.gsautofinale.Products.Kingpins.KingpinsActivity;
import com.example.karan.gsautofinale.Products.Nuts.NutsActivity;
import com.example.karan.gsautofinale.Products.SpringCenter.SpringCenterActivity;
import com.example.karan.gsautofinale.Products.SpringShackle.SpringShackle;
import com.example.karan.gsautofinale.Products.SpringUBolt.SpringUboltActivity;
import com.example.karan.gsautofinale.Products.Springpin.SpringpinActivity;
import com.example.karan.gsautofinale.Products.Studs.StudsActivity;
import com.example.karan.gsautofinale.Products.Trailer.TrailerActivity;
import com.example.karan.gsautofinale.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    List<Model> model;
    Context context;

    public MainAdapter(List<Model> model, Context context) {
        this.model = model;
        this.context = context;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.main_list,parent,false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MainViewHolder holder, int position) {

        Model models = model.get(position);
        holder.tvPicName.setText(models.getTitle());
        Glide.with(context).load(models.getThumbnial()).into(holder.ivPic);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i = holder.getAdapterPosition();
                if (i == 0){
                    Intent intent = new Intent(context, CheckNutsActivity.class);
                    context.startActivity(intent);

                }else if (i == 1){
                    Intent intent = new Intent(context, StudsActivity.class);
                    context.startActivity(intent);

                }else if (i == 2){
                    Intent intent = new Intent(context, KingpinsActivity.class);
                    context.startActivity(intent);

                }else if (i == 3){
                    Intent intent = new Intent(context, SpringpinActivity.class);
                    context.startActivity(intent);

                }else if(i == 4){
                    Intent intent = new Intent(context, MiscBoltsActivity.class);
                    context.startActivity(intent);

                }else if (i == 5){
                    Intent intent = new Intent(context, SpringCenterActivity.class);
                    context.startActivity(intent);

                }else if (i == 6){
                    Intent intent = new Intent(context, SpringUboltActivity.class);
                    context.startActivity(intent);

                }else if (i == 7){
                    Intent intent = new Intent(context, CastedActivity.class);
                    context.startActivity(intent);

                }else if (i == 8){
                    Intent intent = new Intent(context, CastedRingsActivity.class);
                    context.startActivity(intent);

                }else if (i == 9){
                    Intent intent = new Intent(context, NutsActivity.class);
                    context.startActivity(intent);

                }else if (i == 10){
                    Intent intent = new Intent(context, HubboltsActivity.class);
                    context.startActivity(intent);
                }else if (i == 11){
                    Intent intent = new Intent(context, SpringShackle.class);
                    context.startActivity(intent);
                }else if (i == 12){
                    Intent intent = new Intent(context, TrailerActivity.class);
                    context.startActivity(intent);
                }else if (i == 13){
                    Intent intent = new Intent(context, HubWashersActivity.class);
                    context.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPic;
        TextView tvPicName;
        CardView cardView;

        public MainViewHolder(View itemView) {
            super(itemView);

            ivPic = (ImageView) itemView.findViewById(R.id.ivPic);
            tvPicName = (TextView) itemView.findViewById(R.id.tvPicName);
            cardView = (CardView) itemView.findViewById(R.id.cardView);


        }
    }
}
