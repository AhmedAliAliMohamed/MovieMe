package com.example.movieme.Ui.SignIn;


import android.os.Bundle;
import android.view.View;

import com.example.movieme.Base.BaseActivity;
import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.databinding.ActivitySignInEmailAndPasswordBinding;


public class SignInEmailAndPasswordActivity extends BaseActivity {
    private ActivitySignInEmailAndPasswordBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        statusBarHideAndActionBar();
        DefineToolbar(" ");
    }
    public void DefineToolbar(String title){
        super.DefineToolbar(title);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }




    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public View getView() {
        binding = ActivitySignInEmailAndPasswordBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
    @Override
    public void initObservers() {

    }
}