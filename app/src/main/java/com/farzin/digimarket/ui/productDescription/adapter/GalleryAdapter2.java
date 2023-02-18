package com.farzin.digimarket.ui.productDescription.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.GalleryRowBinding;
import com.farzin.digimarket.models.Gallery;

import java.util.List;

public class GalleryAdapter2 extends RecyclerView.Adapter<GalleryAdapter2.MyViewHolder> {

    private Context context;
    private List<Gallery> galleryList;

    public GalleryAdapter2(Context context, List<Gallery> galleryList) {
        this.context = context;
        this.galleryList = galleryList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        GalleryRowBinding binding = GalleryRowBinding.inflate(inflater,parent,false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Glide.with(context)
                .asBitmap()
                .placeholder(R.drawable.placeholder)
                .load(galleryList.get(position).getImg())
                .into(holder.binding.gallery);
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        GalleryRowBinding binding;

        public MyViewHolder(GalleryRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
