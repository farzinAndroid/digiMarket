package com.farzin.digimarket.ui.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.ActivitySearchBinding;
import com.farzin.digimarket.models.BaseModel;
import com.farzin.digimarket.ui.baseView.IView;
import com.farzin.digimarket.ui.main.home.adapter.AmazingOfferAdapter;

public class SearchActivity extends AppCompatActivity implements IView {

    private ActivitySearchBinding binding;

    private SearchPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();

        presenter = new SearchPresenter(new SearchInteractor(),this);

        binding.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.edtSearch.getText().toString().trim().equals("")){
                    Toast.makeText(SearchActivity.this, getString(R.string.please_enter_text), Toast.LENGTH_SHORT).show();
                }else {
                    presenter.search(binding.edtSearch.getText().toString());
                }


            }
        });


    }

















    private void startBinding() {
        binding = ActivitySearchBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object responseMessage) {
        BaseModel baseModel = (BaseModel) responseMessage;
        binding.searchRv.setAdapter(new AmazingOfferAdapter(getApplicationContext(),baseModel.getProductsList()));
        binding.searchRv.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
    }

    @Override
    public void onError(String onError) {

    }
}