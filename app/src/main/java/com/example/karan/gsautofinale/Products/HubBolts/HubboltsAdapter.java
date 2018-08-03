package com.example.karan.gsautofinale.Products.HubBolts;

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
import com.example.karan.gsautofinale.R;

import java.util.List;

public class HubboltsAdapter extends RecyclerView.Adapter<HubboltsAdapter.HubboltsViewHolder> {

    Context context;
    List<ProductModel> productModels;

    public HubboltsAdapter(Context context, List<ProductModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public HubboltsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_model,parent,false);
        return new HubboltsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HubboltsViewHolder holder, final int position) {

        ProductModel productModel = productModels.get(position);
        holder.tvCode.setText(productModels.get(position).getCode());
        holder.tvSize.setText(productModels.get(position).getSize());
        holder.tvModel.setText(productModels.get(position).getModel());
        holder.tvPrice.setText(productModels.get(position).getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("Code",productModels.get(position).getCode());
                intent.putExtra("Size",productModels.get(position).getSize());
                intent.putExtra("Model",productModels.get(position).getModel());
                intent.putExtra("Price",productModels.get(position).getPrice());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class HubboltsViewHolder extends RecyclerView.ViewHolder{

        TextView tvCode,tvSize,tvModel,tvPrice;
        CardView cardView;

        public HubboltsViewHolder(View itemView) {
            super(itemView);

            tvCode = (TextView) itemView.findViewById(R.id.tvCode);
            tvSize = (TextView) itemView.findViewById(R.id.tvSize);
            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }
    }

}
