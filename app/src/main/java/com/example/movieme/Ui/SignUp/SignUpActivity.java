package com.example.movieme.Ui.SignUp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.movieme.Base.BaseActivity;
import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.R;
import com.example.movieme.databinding.ActivitySignUpBinding;

public class SignUpActivity extends BaseActivity {
    private ActivitySignUpBinding binding;
    private ViewModelSignUp viewModelSignUp;
    private String email , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        statusBarHideAndActionBar();
        DefineToolbar("");
        initListener();
    }

    public void DefineToolbar(String title){
        super.DefineToolbar(title);
        toolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @Override
    public BaseViewModel getViewModel() {
        viewModelSignUp = new ViewModelProvider(this).get(ViewModelSignUp.class);
        return null;
    }

    @Override
    public View getView() {
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
    @Override
    public void initObservers() {
        viewModelSignUp.getEmailAndPasswordValidationMLD().observe(this,valid ->{
            if (!valid){
                deActiveBtn(true,getString(R.string.sign_up));
                binding.pbSignUp.setVisibility(View.GONE);
            }
        });
        viewModelSignUp.getMassageMLD().observe(this , massage ->{
            if (massage.equalsIgnoreCase(getString(R.string.you_can_not_enter_empty_value))){
                binding.edEmail.setError(massage);
                binding.edPassword.setError(massage);
                return;
            }
            if (massage.equalsIgnoreCase(getString(R.string.the_email_not_matching))){
                binding.edEmail.setError(massage);
                return;
            }
            if (massage.equalsIgnoreCase(getString(R.string.password_must_be_less_than))){
                binding.edPassword.setError(massage);
                return;
            }
        });

    }


    private void initListener(){
        binding.btnSignUp.setOnClickListener(v ->{
           viewModelSignUp.setEmail(binding.edEmail.getText().toString());
           viewModelSignUp.setPassword(binding.edPassword.getText().toString());
           viewModelSignUp.getValid();
           deActiveBtn(false,"");
            binding.pbSignUp.setVisibility(View.VISIBLE);

        });
    }

    private void deActiveBtn(Boolean active,String text){
        binding.btnSignUp.setClickable(active);
        binding.btnSignUp.setEnabled(active);
        binding.btnSignUp.setFocusable(active);
        binding.btnSignUp.setText(text);

    }




}