package com.farzin.digimarket.ui.main.category;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.FragmentCategoryBinding;
import com.farzin.digimarket.models.BaseModel;
import com.farzin.digimarket.ui.main.category.adapter.BrandsAdapter;
import com.farzin.digimarket.ui.main.category.adapter.CategoryAdapter;


public class CategoryFragment extends Fragment implements ICategoryView {


    private FragmentCategoryBinding binding;

    private CategoryPresenter categoryPresenter;

    public CategoryFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentCategoryBinding.inflate(inflater,container,false);

        categoryPresenter = new CategoryPresenter(this,new CategoryIntractor());
        categoryPresenter.getCategoryData();














        return binding.getRoot();
    }

    @Override
    public void showProgressBar() {
        binding.progressBar2.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar2.setVisibility(View.GONE);
    }

    @Override
    public void onSuccess(Object responseMessage) {
        BaseModel baseModel = (BaseModel) responseMessage;

        // setting up Category RV
        binding.rvCategories.setAdapter(new CategoryAdapter(getActivity(),baseModel.getCategories()));
        binding.rvCategories.setLayoutManager(new GridLayoutManager(getActivity(),2));
        binding.rvCategories.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));

        //setting up Brands RV
        binding.rvBrands.setAdapter(new BrandsAdapter(getActivity(),baseModel.getBrands()));
        binding.rvBrands.setLayoutManager(new GridLayoutManager(getActivity(),2));
        binding.rvCategories.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.HORIZONTAL));

    }

    @Override
    public void onError(String error) {

    }
}