package com.android.onlineshoppingapp.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.onlineshoppingapp.R;
import com.android.onlineshoppingapp.models.Order;

import java.util.List;

public class BestSellingAdapter extends RecyclerView.Adapter<BestSellingAdapter.BestSellingViewHolder> {

    private final List<Order> orderList;

    public BestSellingAdapter(List<Order> orderList) {
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public BestSellingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_best_selling, parent, false);
        return new BestSellingViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull BestSellingViewHolder holder, int position) {
        Order order = orderList.get(position);
        if (order == null)
            return;

        holder.tvProductName.setText("Product name");
        holder.tvProductCate.setText("Type of product");
        holder.tvNumberOfSold.setText(String.valueOf(0));
    }

    @Override
    public int getItemCount() {
        if (orderList.isEmpty())
            return 0;
        return orderList.size();
    }

    static class BestSellingViewHolder extends RecyclerView.ViewHolder {

        private final ImageView ivProductImage;
        private final TextView tvProductName;
        private final TextView tvProductCate;
        private final TextView tvNumberOfSold;

        public BestSellingViewHolder(@NonNull View itemView) {
            super(itemView);

            ivProductImage = itemView.findViewById(R.id.ivImageProductBestSelling);
            tvProductName = itemView.findViewById(R.id.tvProductNameBestSelling);
            tvProductCate = itemView.findViewById(R.id.tvProductCateBestSelling);
            tvNumberOfSold = itemView.findViewById(R.id.tvBestSellingSold);

        }
    }
}
