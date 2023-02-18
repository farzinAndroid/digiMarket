package com.farzin.digimarket.ui.main.home.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.digimarket.databinding.AmazingOfferRowBinding;

public class AmazingOfferVH extends RecyclerView.ViewHolder {

    AmazingOfferRowBinding binding;
    public AmazingOfferVH(AmazingOfferRowBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
}
