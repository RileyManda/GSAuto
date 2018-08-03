package com.example.karan.gsautofinale.Products.Casted;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.karan.gsautofinale.DetailActivity;
import com.example.karan.gsautofinale.ListItem;
import com.example.karan.gsautofinale.ProductModelTwo;
import com.example.karan.gsautofinale.R;

import java.util.List;


public class CastedAdapter extends RecyclerView.Adapter<CastedAdapter.CastedViewHolder>{

    private List<ListItem> listItems;
    Context context;


    public CastedAdapter(List<ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public CastedViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_model,parent,false);
        return new CastedViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CastedViewHolder holder, final int position) {

        final ListItem listItem = listItems.get(position);
        holder.tvCode.setText(listItem.getCode());
        holder.tvSize.setText(listItem.getApps());
        holder.tvModel.setText(listItem.getModel());
        holder.tvPrice.setText(listItem.getPrice());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,DetailActivity.class);
                intent.putExtra("Code",listItems.get(position).getCode());
                intent.putExtra("Size",listItems.get(position).getApps());
                intent.putExtra("Model",listItems.get(position).getModel());
                intent.putExtra("Price",listItems.get(position).getPrice());
                intent.putExtra("Pic",listItems.get(position).getPic());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class CastedViewHolder extends RecyclerView.ViewHolder{

        TextView tvCode, tvModel, tvSize, tvPrice;
        ImageView extraImage;
        CardView cardView;

        public CastedViewHolder(View itemView) {
            super(itemView);

            tvCode = (TextView) itemView.findViewById(R.id.tvCode);
            tvSize = (TextView) itemView.findViewById(R.id.tvSize);
            tvModel = (TextView) itemView.findViewById(R.id.tvModel);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);

            cardView = (CardView) itemView.findViewById(R.id.cardView);

        }

    }
}
