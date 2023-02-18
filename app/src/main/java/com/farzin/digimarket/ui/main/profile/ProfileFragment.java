package com.farzin.digimarket.ui.main.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.farzin.digimarket.R;
import com.farzin.digimarket.config.AppSettings;
import com.farzin.digimarket.databinding.FragmentProfileBinding;
import com.farzin.digimarket.ui.register.ILoginView;
import com.farzin.digimarket.ui.register.LoginIntractor;
import com.farzin.digimarket.ui.register.LoginPresenter;
import com.farzin.digimarket.ui.register.RegisterActivity;


public class ProfileFragment extends Fragment implements ILoginView {


    private FragmentProfileBinding binding;

    private LoginPresenter loginPresenter;

    AppSettings appSettings ;

    public ProfileFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(inflater,container,false);

        loginPresenter = new LoginPresenter(this,new LoginIntractor(getActivity()));

        appSettings = new AppSettings(getActivity());
        if (appSettings.getID() > 0){
            binding.cardView.setVisibility(View.GONE);
            binding.progressBar3.setVisibility(View.GONE);
        }


        binding.txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), RegisterActivity.class));
            }
        });

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName = binding.userEdt.getText().toString();
                String password = binding.passwordEdt.getText().toString();

                loginPresenter.login(userName,password);
            }
        });





        return binding.getRoot();
    }

    @Override
    public void onUserNameError() {
        binding.userEdt.setError(getString(R.string.user_name_required));
    }

    @Override
    public void onPasswordError() {
        binding.passwordEdt.setError(getString(R.string.pass_required));
    }

    @Override
    public void onFailure() {
        Toast.makeText(getActivity(), R.string.error_login, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), R.string.success_login, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgressBar() {
        binding.progressBar3.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar3.setVisibility(View.GONE);
    }
}