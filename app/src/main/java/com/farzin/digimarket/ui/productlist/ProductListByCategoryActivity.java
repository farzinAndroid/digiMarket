package com.farzin.digimarket.ui.productlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.ActivityProductListByCategoryBinding;
import com.farzin.digimarket.databinding.AmazingOfferRowBinding;
import com.farzin.digimarket.models.BaseModel;
import com.farzin.digimarket.models.Category;
import com.farzin.digimarket.ui.main.home.adapter.AmazingOfferAdapter;
import com.farzin.digimarket.ui.main.home.adapter.ProductAdapter;
import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

public class ProductListByCategoryActivity extends AppCompatActivity implements IProductListView{


    private ActivityProductListByCategoryBinding binding;

    private Bundle bundle;
    private Category category;
    private ProductListPresenter presenter;

    ApiCaller apiCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();
        presenter = new ProductListPresenter(this,new ProductInteractor());
        bundle = getIntent().getExtras();
        category = bundle.getParcelable("data");

        presenter.getProductsByCat(Integer.parseInt(category.getId()));


    }





    private void startBinding() {
        binding = ActivityProductListByCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void showProgressBar() {
        binding.progressBar4.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar4.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object onSuccess) {
        BaseModel baseModel = (BaseModel) onSuccess;

        binding.progressBar4.setVisibility(View.GONE);
        binding.recyclerView.setAdapter(new AmazingOfferAdapter(getApplicationContext(),baseModel.getProductsList()));
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onError(String error) {

    }
}