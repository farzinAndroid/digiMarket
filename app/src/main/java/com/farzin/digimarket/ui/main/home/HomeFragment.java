package com.farzin.digimarket.ui.main.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.FragmentHomeBinding;
import com.farzin.digimarket.models.BaseModel;
import com.farzin.digimarket.ui.main.home.adapter.AmazingOfferAdapter;
import com.farzin.digimarket.ui.main.home.adapter.ProductAdapter;
import com.farzin.digimarket.ui.search.SearchActivity;
import com.farzin.digimarket.webService.ApiCaller;
import com.farzin.digimarket.webService.IMessageListener;

import java.util.List;


public class HomeFragment extends Fragment implements IHomeView {


    private FragmentHomeBinding binding;

    ApiCaller apiCaller;

    private HomePresenter homePresenter;

    public HomeFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater,container,false);

        apiCaller = new ApiCaller();



        homePresenter = new HomePresenter(this,new HomeInteractor());
        homePresenter.getHomeWebService();


        binding.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });










        return binding.getRoot();
    }

    @Override
    public void showProgressBar() {
        binding.progressBarHome.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBarHome.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object responseMessage) {
        Log.e("", "");

        BaseModel baseModel = (BaseModel) responseMessage;

        //Discounts RV
        binding.rvDiscounts.setAdapter(new ProductAdapter(baseModel.getDiscount(),getActivity()));
        binding.rvDiscounts.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL,false));

        //MakeUp RV
        binding.rvMakupOffers.setAdapter(new ProductAdapter(baseModel.getMakeUp(),getActivity()));
        binding.rvMakupOffers.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));

        //Amazing Offer RV
        binding.rvSpecialOffers.setAdapter(new AmazingOfferAdapter(getActivity(),baseModel.getAmazingOffer()));
        binding.rvSpecialOffers.setLayoutManager(new GridLayoutManager(getActivity(),2));


    }

    @Override
    public void onError(String onError) {
        Log.e("", "");
    }
}