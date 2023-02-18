package com.farzin.digimarket.ui.main.shoppingCart.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.farzin.digimarket.R;
import com.farzin.digimarket.dataBase.DigiDatabase;
import com.farzin.digimarket.databinding.CartRowBinding;
import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.models.ShoppingCartRoom;
import com.farzin.digimarket.ui.productDescription.IProductView;
import com.farzin.digimarket.ui.productDescription.ProductDescriptionInteractor;
import com.farzin.digimarket.ui.productDescription.ProductDescriptionPresenter;

import java.util.List;

public class ShoppingCartAdapter extends RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder>{

    private Context context;
    private List<ShoppingCartRoom> shoppingCartRoomList;
    private DigiDatabase digiDatabase;

    public ShoppingCartAdapter(Context context, List<ShoppingCartRoom> shoppingCartRoomList) {
        this.context = context;
        this.shoppingCartRoomList = shoppingCartRoomList;
        digiDatabase = DigiDatabase.getInstance(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        CartRowBinding binding = CartRowBinding.inflate(layoutInflater,parent,false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.binding.txtPrice.setText(shoppingCartRoomList.get(position).getPrice() + " تومان");
        holder.binding.txtTitle.setText(shoppingCartRoomList.get(position).getTitle());

        Glide.with(context)
                .asBitmap()
                .placeholder(R.drawable.placeholder)
                .load(shoppingCartRoomList.get(position).getIcon())
                .into(holder.binding.imgProduct);

        holder.binding.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               digiDatabase.roomDAO().delete(shoppingCartRoomList.get(holder.getAdapterPosition()));
                Toast.makeText(context, context.getString(R.string.remove_from_cart), Toast.LENGTH_SHORT).show();
                shoppingCartRoomList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeRemoved(holder.getAdapterPosition(),shoppingCartRoomList.size());
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return shoppingCartRoomList.size();
    }





    class MyViewHolder extends RecyclerView.ViewHolder{

        CartRowBinding binding;

        public MyViewHolder(CartRowBinding binding) {
            super(binding.getRoot());
            this.binding =  binding;
        }
    }

    public void clear(){
        shoppingCartRoomList.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<ShoppingCartRoom> shoppingCartRooms){
        shoppingCartRoomList.clear();
        shoppingCartRoomList.addAll(shoppingCartRooms);
        notifyDataSetChanged();
    }
}
