package com.example.karan.gsautofinale;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    List<ProductModel> productModels;
    Context context;

    public SearchAdapter(List<ProductModel> productModels, Context context) {
        this.productModels = productModels;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_model,parent,false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, final int position) {

        final ProductModel model = productModels.get(position);
        holder.tvCode.setText(model.getCode());
        holder.tvSize.setText(model.getSize());
        holder.tvModel.setText(model.getModel());
        holder.tvPrice.setText(model.getPrice());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public static class SearchViewHolder extends RecyclerView.ViewHolder implements OnItemClickListener{

        TextView tvCode,tvSize,tvModel,tvPrice;
        CardView cardView;

        public SearchViewHolder(View itemView) {
            super(itemView);

            tvCode = (TextView) itemView.findViewById(R.id.tvCode);
            tvSize = (TextView) itemView.findViewById(R.id.tvSize);
            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }

        public void setDetails(String Code,String Size,String Model,String Price){

            TextView codee = (TextView) itemView.findViewById(R.id.tvCode);
            TextView sizee = (TextView) itemView.findViewById(R.id.tvSize);
            TextView modell = (TextView) itemView.findViewById(R.id.tvModel);
            TextView pricee = (TextView) itemView.findViewById(R.id.tvPrice);

            codee.setText(Code);
            sizee.setText(Size);
            modell.setText(Model);
            pricee.setText(Price);
        }

        @Override
        public void onItemClick(int pos) {

        }
    }

    public interface OnItemClickListener {
        void onItemClick(int pos);
    }

}
