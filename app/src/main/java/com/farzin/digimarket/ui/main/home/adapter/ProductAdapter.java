package com.farzin.digimarket.ui.main.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.ProductRowBinding;
import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.ui.productDescription.ProductDescriptionActivity;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Products> productsList;
    private Context context;

    public ProductAdapter(List<Products> productsList, Context context) {
        this.productsList = productsList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ProductRowBinding productRowBinding = ProductRowBinding.inflate(layoutInflater, parent, false);
        return new ProductViewHolder(productRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {

        Glide.with(context).asBitmap()
                .load(productsList.get(position).getIcon())
                .placeholder(R.drawable.placeholder)
                .into(holder.binding.imgProduct);

        holder.binding.discountsTxt.setText(productsList.get(position).getDiscount() + " % ");

        int size = productsList.get(position).getTitle().length();
        if (size >=15){
            String title = productsList.get(position).getTitle().substring(0,15);
            holder.binding.txtTitle.setText(title+"...");
//            holder.binding.txtTitle.setText(productsList.get(position).getTitle());
//            holder.binding.txtTitle.setMovementMethod(new ScrollingMovementMethod());
//            holder.binding.txtTitle.setHorizontallyScrolling(true);


        }else {
            holder.binding.txtTitle.setText(productsList.get(position).getTitle());
        }



        holder.binding.txtPrice.setText(String.valueOf(productsList.get(position).getPrice()));

        //change any Type To Float
        holder.binding.ratingBar.setRating(Float.parseFloat(productsList.get(position).getRate()));

        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductDescriptionActivity.class);
                intent.putExtra("data",productsList.get(holder.getAdapterPosition()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }
}
