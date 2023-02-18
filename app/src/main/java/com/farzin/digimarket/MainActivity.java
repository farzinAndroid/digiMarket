package com.farzin.digimarket;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.farzin.digimarket.databinding.ActivityMainBinding;
import com.farzin.digimarket.di.retrofit.MyApplication;
import com.farzin.digimarket.di.user.DaggerUserComponent;
import com.farzin.digimarket.di.user.UserComponent;
import com.farzin.digimarket.di.user.UserModule;
import com.farzin.digimarket.di.test.CustomeContact;
import com.farzin.digimarket.di.test.SimpleContact;
import com.farzin.digimarket.di.test.User;
import com.farzin.digimarket.models.BaseModel;
import com.farzin.digimarket.ui.main.category.CategoryFragment;
import com.farzin.digimarket.ui.main.adapter.FragmentAdapter;
import com.farzin.digimarket.ui.main.home.HomeFragment;
import com.farzin.digimarket.ui.main.profile.ProfileFragment;
import com.farzin.digimarket.ui.main.shoppingCart.ShoppingCartFragment;
import com.farzin.digimarket.webService.ApiService;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Inject
    Retrofit retrofit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Locale locale = new Locale("fa");
//        Locale.setDefault(locale);
//
//        Configuration configuration = new Configuration();
//        configuration.locale = locale;
//
//        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());


        //start binding
        startBinding();
        //setUpBottomNavViewPager items
        setUpBottomNavViewPager();




        // DI ///////////////////////////////////
        User user = new User(new SimpleContact());
        user.contacts.deleteContacts("");
        User user1 = new User(new CustomeContact());
        user1.contacts.insertContacts("","");


        UserComponent userComponent = DaggerUserComponent.builder().userModule(new UserModule())
                .build();

        userComponent.provideUser().insertEmail("@farzin.com");
        String email = userComponent.provideUser().showEmail();
        Toast.makeText(this, email, Toast.LENGTH_SHORT).show();







//        ((MyApplication)getApplication()).getApiComponent().inject(MainActivity.this);
//
//        ApiService apiService = retrofit.create(ApiService.class);
//
//        Call<BaseModel> call = apiService.getCategories();
//        call.enqueue(new Callback<BaseModel>() {
//            @Override
//            public void onResponse(Call<BaseModel> call, Response<BaseModel> response) {
//                Log.e("", "");
//            }
//
//            @Override
//            public void onFailure(Call<BaseModel> call, Throwable t) {
//                Log.e("", "");
//            }
//        });



        //DI /////////////////////////////////////


    }









    //setUpBottomNavViewPager items
    private void setUpBottomNavViewPager() {
        //start Calling Fragments
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new CategoryFragment());
        fragmentList.add(new ShoppingCartFragment());
        fragmentList.add(new ProfileFragment());

        //set adapter
        binding.viewPager.setAdapter(new FragmentAdapter(this, fragmentList));

        //scrolling viewpager
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);

                binding.bottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
        });

        //navigation Items
        binding.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.bottom_nav_home:
                        binding.bottomNavigationView.getMenu().getItem(0).setChecked(true);
                        binding.viewPager.setCurrentItem(0);
                        break;

                    case R.id.bottom_nav_category:
                        binding.bottomNavigationView.getMenu().getItem(1).setChecked(true);
                        binding.viewPager.setCurrentItem(1);
                        break;

                    case R.id.bottom_nav_cart:
                        binding.bottomNavigationView.getMenu().getItem(2).setChecked(true);
                        binding.viewPager.setCurrentItem(2);
                        break;

                    case R.id.bottom_nav_profile:
                        binding.bottomNavigationView.getMenu().getItem(3).setChecked(true);
                        binding.viewPager.setCurrentItem(3);
                        break;
                }

                return false;
            }
        });
    }


    //start binding
    private void startBinding() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}