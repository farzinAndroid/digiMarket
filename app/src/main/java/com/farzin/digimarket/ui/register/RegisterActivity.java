package com.farzin.digimarket.ui.register;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.farzin.digimarket.R;
import com.farzin.digimarket.databinding.ActivityLoginBinding;

//implement ILoginView for MVP
public class RegisterActivity extends AppCompatActivity implements ILoginView {

    private ActivityLoginBinding binding;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startBinding();
        loginPresenter = new LoginPresenter(this, new LoginIntractor(getApplicationContext()));


        binding.registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userName = binding.userEdt.getText().toString();
                String password = binding.passwordEdt.getText().toString();


                loginPresenter.register(userName, password);

            }
        });
    }

    // start binding
    private void startBinding() {
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
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

        Toast.makeText(this, R.string.error_login, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSuccess() {

        Toast.makeText(this, R.string.success_login, Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
            }
        },500);
    }

    @Override
    public void showProgressBar() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        binding.progressBar.setVisibility(View.GONE);
    }
}