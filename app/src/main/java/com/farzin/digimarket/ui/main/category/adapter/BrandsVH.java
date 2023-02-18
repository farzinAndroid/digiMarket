package com.farzin.digimarket.ui.main.category.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.digimarket.databinding.BrandsRowBinding;

public class BrandsVH extends RecyclerView.ViewHolder {

    BrandsRowBinding binding;

    public BrandsVH(BrandsRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
