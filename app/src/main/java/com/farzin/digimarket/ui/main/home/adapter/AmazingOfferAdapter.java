package com.farzin.digimarket.ui.main.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.AmazingOfferRowBinding;
import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.ui.productDescription.ProductDescriptionActivity;

import java.util.List;

public class AmazingOfferAdapter extends RecyclerView.Adapter<AmazingOfferVH> {

    private Context context;
    private List<Products> productsList;

    public AmazingOfferAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public AmazingOfferVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        AmazingOfferRowBinding binding = AmazingOfferRowBinding.inflate(layoutInflater);
        return new AmazingOfferVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull AmazingOfferVH holder, int position) {


        Products products = productsList.get(position);


        holder.binding.txtTitle.setText(products.getTitle());

        holder.binding.txtBrand.setText(products.getBrand());

        holder.binding.txtDiscount.setText(products.getDiscount() + " % ");

        Glide.with(context)
                .asBitmap()
                .placeholder(R.drawable.placeholder)
                .load(products.getIcon())
                .into(holder.binding.imgProduct);

        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDescriptionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("data",products);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
