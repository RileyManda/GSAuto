package com.example.karan.gsautofinale.Products.Trailer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.karan.gsautofinale.DetailActivity;
import com.example.karan.gsautofinale.ProductModel;
import com.example.karan.gsautofinale.ProductModelTwo;
import com.example.karan.gsautofinale.R;

import java.util.List;

public class TrailerAdapter extends RecyclerView.Adapter<TrailerAdapter.TrailerViewHolder>{

    List<ProductModelTwo> productModelTwos;
    Context context;

    public TrailerAdapter(List<ProductModelTwo> productModelTwos, Context context) {
        this.productModelTwos = productModelTwos;
        this.context = context;
    }

    @NonNull
    @Override
    public TrailerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_model,parent,false);
        return new TrailerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrailerViewHolder holder, final int position) {

        ProductModelTwo productModelTwo = productModelTwos.get(position);
        holder.tvCode.setText(productModelTwo.getCode());
        holder.tvModel.setText(productModelTwo.getApps());
        holder.tvCode.setText(productModelTwo.getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("Code",productModelTwos.get(position).getCode());
                intent.putExtra("Apps",productModelTwos.get(position).getApps());
                intent.putExtra("Size",productModelTwos.get(position).getSize());
                intent.putExtra("Model",productModelTwos.get(position).getModel());
                intent.putExtra("Price",productModelTwos.get(position).getPrice());
                intent.putExtra("Inch",productModelTwos.get(position).getInch());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productModelTwos.size();
    }

    public class TrailerViewHolder extends RecyclerView.ViewHolder{

        TextView tvCode,tvSize,tvModel,tvPrice;
        CardView cardView;

        public TrailerViewHolder(View itemView) {
            super(itemView);

            tvCode = (TextView) itemView.findViewById(R.id.tvCode);
            tvSize = (TextView) itemView.findViewById(R.id.tvSize);
            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }
}
