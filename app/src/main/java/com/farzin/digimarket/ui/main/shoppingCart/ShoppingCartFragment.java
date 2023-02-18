package com.farzin.digimarket.ui.main.shoppingCart;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.FragmentShoppingCartBinding;
import com.farzin.digimarket.models.ShoppingCartRoom;
import com.farzin.digimarket.ui.main.shoppingCart.adapter.ShoppingCartAdapter;
import com.farzin.digimarket.ui.productDescription.IProductView;
import com.farzin.digimarket.ui.productDescription.ProductDescriptionInteractor;
import com.farzin.digimarket.ui.productDescription.ProductDescriptionPresenter;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartFragment extends Fragment implements IProductView {


    private FragmentShoppingCartBinding binding;

    private ProductDescriptionPresenter presenter;



    public ShoppingCartFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentShoppingCartBinding.inflate(inflater,container,false);



        presenter = new ProductDescriptionPresenter(this,new ProductDescriptionInteractor(getContext()));
        presenter.showAll();

        /*binding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(getContext(), "Refresh", Toast.LENGTH_SHORT).show();
                FragmentTransaction ft = getParentFragmentManager().beginTransaction();
                if (Build.VERSION.SDK_INT >= 26) {
                    ft.setReorderingAllowed(false);
                }
                ft.detach(ShoppingCartFragment.this).attach(ShoppingCartFragment.this).commit();
                presenter.showAll();
                binding.refresh.setRefreshing(false);
            }
        });*/














        return binding.getRoot();
    }

    @Override
    public void onAddedSuccessfully(int id) {

    }

    @Override
    public void onDeletedSuccessfully() {

    }

    @Override
    public void onError() {

    }

    @Override
    public void showAll(List<ShoppingCartRoom> shoppingCartRooms) {

        ShoppingCartAdapter shoppingCartAdapter = new ShoppingCartAdapter(getContext(),shoppingCartRooms);

        binding.cartRv.setAdapter(shoppingCartAdapter);
        binding.cartRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        binding.cartRv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }
}