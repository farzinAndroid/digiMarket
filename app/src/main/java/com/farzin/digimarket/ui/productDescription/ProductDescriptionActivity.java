package com.farzin.digimarket.ui.productDescription;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.ActivityProductDescriptionBinding;
import com.farzin.digimarket.models.Products;
import com.farzin.digimarket.models.ShoppingCartRoom;
import com.farzin.digimarket.ui.productDescription.adapter.GalleryAdapter2;

import java.util.List;

public class ProductDescriptionActivity extends AppCompatActivity implements IProductView {
    private ActivityProductDescriptionBinding binding;

    private Bundle bundle;
    private Products products;
    private ProductDescriptionPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();
        getData();
        presenter =  new ProductDescriptionPresenter(this,new ProductDescriptionInteractor(getApplicationContext()));

        binding.imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        binding.txtPrice.setText(products.getPrice() + " " + getString(R.string.tooman));
        binding.productTitle.setText(products.getTitle());
        binding.ratingBar.setRating(Float.parseFloat(products.getRate()));
        binding.shortDesc.setText(products.getShortDescription());
        binding.fullshortDesc.setText(products.getFullDescription());


        binding.pagerGallery.setAdapter(new GalleryAdapter2(getApplicationContext(),products.getGalleries()));

        binding.springDotsIndicator.attachTo(binding.pagerGallery);
        binding.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.addToCart(products);
            }
        });

        binding.imgRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.delete(products);
            }
        });





    }

    private void getData() {
        bundle = getIntent().getExtras();

        products = bundle.getParcelable("data");
    }

    private void startBinding() {
        binding = ActivityProductDescriptionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }


    @Override
    public void onAddedSuccessfully(int id) {
        Toast.makeText(this, getString(R.string.added_tocart_successfully), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDeletedSuccessfully() {
        Toast.makeText(this, getString(R.string.remove_from_cart), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError() {
        Toast.makeText(this, getString(R.string.products_didnt_add), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showAll(List<ShoppingCartRoom> shoppingCartRooms) {

    }
}