package com.farzin.digimarket.ui.main.category;

import com.farzin.digimarket.webService.IMessageListener;

public class CategoryPresenter implements IMessageListener {

    ICategoryView iCategoryView;
    CategoryIntractor categoryIntractor;

    public CategoryPresenter(ICategoryView iCategoryView, CategoryIntractor categoryIntractor) {
        this.iCategoryView = iCategoryView;
        this.categoryIntractor = categoryIntractor;
    }

    public void getCategoryData(){

        iCategoryView.showProgressBar();
        categoryIntractor.getCategories(this);

    }

    @Override
    public void onResponse(Object onResponse) {
        iCategoryView.hideProgressBar();
        iCategoryView.onSuccess(onResponse);
    }

    @Override
    public void onError(String onError) {
        iCategoryView.hideProgressBar();
        iCategoryView.onError(onError);
    }
}
