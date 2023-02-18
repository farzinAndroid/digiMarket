package com.farzin.digimarket.ui.main.category.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.digimarket.databinding.CategoryRowBinding;

public class CategoryVH extends RecyclerView.ViewHolder {

    CategoryRowBinding binding;

    public CategoryVH(CategoryRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
