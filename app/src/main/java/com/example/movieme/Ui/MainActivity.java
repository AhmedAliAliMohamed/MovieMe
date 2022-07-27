package com.example.movieme.Ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.movieme.Base.BaseActivity;
import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.R;
import com.example.movieme.databinding.ActivityMainBinding;

public class MainActivity extends BaseActivity {

    private ActivityMainBinding binding;
    private final static int DAILY= 3000;
    private Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(getView());
       statusBarHideAndActionBar();
       animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_animation);
       binding.lottieLogo.startAnimation(animation);
       if (!binding.lottieLogo.getAnimation().getFillAfter())
           binding.lottieLogo.postDelayed(() -> {
               binding.pbSplash.setVisibility(View.VISIBLE);
               binding.pbSplash.postDelayed(() -> doIntent(),DAILY);
           },DAILY);


    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public View getView() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        return view;
    }
    @Override
    public void initObservers() {

    }

    private void doIntent(){
        startActivity(new Intent(MainActivity.this,AppInfoActivity.class));
        finish();
    }


}