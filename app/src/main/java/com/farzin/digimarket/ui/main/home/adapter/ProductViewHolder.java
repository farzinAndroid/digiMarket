package com.farzin.digimarket.ui.main.home.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.digimarket.databinding.ProductRowBinding;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ProductRowBinding binding;

    public ProductViewHolder(ProductRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
