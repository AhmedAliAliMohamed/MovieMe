package com.example.movieme.Ui.SignIn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.movieme.Base.BaseActivity;
import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.Ui.SignUp.SignUpActivity;
import com.example.movieme.databinding.ActivitySignInWithAnthorBinding;

public class SignInWithAnthorActivity extends BaseActivity {
    private ActivitySignInWithAnthorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        statusBarHideAndActionBar();
        initListener();
    }



    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public View getView() {
        binding = ActivitySignInWithAnthorBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
    @Override
    public void initObservers() {

    }

    private void initListener(){
        binding.btnSignWithPassword.setOnClickListener(v ->{
            startActivity(new Intent(this,SignInEmailAndPasswordActivity.class));
        });
        binding.tvSignUp.setOnClickListener(v ->{
            startActivity(new Intent(this, SignUpActivity.class));
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}