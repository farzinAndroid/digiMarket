package com.farzin.digimarket.ui.main.category.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.CategoryRowBinding;
import com.farzin.digimarket.models.Category;
import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.ui.productlist.ProductListByCategoryActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryVH> {

    private Context context;
    private List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CategoryRowBinding binding = CategoryRowBinding.inflate(layoutInflater,parent,false);
        return new CategoryVH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryVH holder, int position) {

        holder.binding.txtTitleCategory.setText(categoryList.get(position).getTitle());

        Glide.with(context)
                .asBitmap()
                .placeholder(R.drawable.placeholder)
                .load(categoryList.get(position).getIcon())
                .into(holder.binding.imgCategory);

        holder.binding.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ProductListByCategoryActivity.class);
                intent.putExtra("data", categoryList.get(holder.getAdapterPosition()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
}
