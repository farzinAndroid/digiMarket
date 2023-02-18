package com.farzin.digimarket.ui.main.category.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.farzin.digimarket.databinding.BrandsRowBinding;
import com.farzin.digimarket.models.Brand;

import java.util.List;

public class BrandsAdapter extends RecyclerView.Adapter<BrandsVH> {

    private Context context;
    private List<Brand> brandList;


    public BrandsAdapter(Context context, List<Brand> brandList) {
        this.context = context;
        this.brandList = brandList;
    }

    @NonNull
    @Override
    public BrandsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        BrandsRowBinding binding = BrandsRowBinding.inflate(layoutInflater);
        return new BrandsVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandsVH holder, int position) {

        holder.binding.txtBrandTitle.setText(brandList.get(position).getBrand());


    }

    @Override
    public int getItemCount() {
        return brandList.size();
    }
}
