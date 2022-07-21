package com.example.movieme.Ui;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.viewpager2.widget.ViewPager2;

import com.example.movieme.Adapters.ViewAdapter;
import com.example.movieme.App.LocalHelper;
import com.example.movieme.Base.BaseActivity;
import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.Models.ViewPagerModel;
import com.example.movieme.R;
import com.example.movieme.Ui.ChangeLanguage.ChangeLanguageFragment;
import com.example.movieme.Utilities.CommonMethod;
import com.example.movieme.Utilities.DialogHelper;
import com.example.movieme.Utilities.SharedPreferenceHelper;
import com.example.movieme.databinding.ActivityAppInfoBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AppInfoActivity extends BaseActivity {
    private ActivityAppInfoBinding binding;
    private ViewAdapter viewAdapter;
    private Animation animation;
    private int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getView());
        statusBarHideAndActionBar();
        btnChangeLanguage();
        initViews();
    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public View getView() {
        binding = ActivityAppInfoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        LocalHelper.setLocal(this);
        return view;
    }

    @Override
    public void initObservers() {

    }

    private void initViews() {
        List<ViewPagerModel> viewPagerModelList = new ArrayList<>();
        viewPagerModelList.add(new ViewPagerModel(R.raw.waving_human_hand_hello_gesture, getString(R.string.welcome_to_movie_me)));
        viewPagerModelList.add(new ViewPagerModel(R.raw.man_watching_a_movie, getString(R.string.the_best_movies_streaming_app_of_the_century)));
        viewPagerModelList.add(new ViewPagerModel(R.raw.entertainment, getString(R.string.you_can_watch_new)));
        viewPagerModelList.add(new ViewPagerModel(R.raw.movie_time_animation, getString(R.string.you_can_also_add_all_your_favorite)));
        viewAdapter = new ViewAdapter(context, viewPagerModelList);
        binding.vpIntro.setAdapter(viewAdapter);
        binding.wormDotsIndicator.setViewPager2(binding.vpIntro);
        anime();


        binding.tvNextIntro.setOnClickListener(view -> {
            binding.vpIntro.setCurrentItem(binding.vpIntro.getCurrentItem() + 1);
            pos = binding.vpIntro.getCurrentItem();
            validationViews(pos);
        });

        binding.tvBackIntro.setOnClickListener(view -> {
            if (binding.tvBackIntro.getText() == getString(R.string.get_start)) {
                Toast.makeText(context, "Ahmed", Toast.LENGTH_SHORT).show();
            } else {
                binding.vpIntro.setCurrentItem(binding.vpIntro.getCurrentItem() - 1);
                pos = binding.vpIntro.getCurrentItem();
                validationViews(pos);
            }
        });
        binding.vpIntro.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                pos = position;
                validationViews(position);
            }
        });


    }

    private void anime() {
        if (binding.tvBackIntro.getVisibility() == View.VISIBLE) {
            binding.tvBackIntro.setText(getString(R.string.get_start));
            animation = AnimationUtils.loadAnimation(this, R.anim.fade_animation);
            binding.tvBackIntro.setAnimation(animation);
            btnChangeLanguage();
        }

    }

    private void btnChangeLanguage() {
        binding.btnChangeLanguage.setOnClickListener(view -> {
            new DialogHelper(new ChangeLanguageFragment(), getSupportFragmentManager());
        });

    }

    private void validationViews(int pos) {
        switch (pos) {
            case 0:
                binding.tvBackIntro.setVisibility(View.GONE);
                binding.tvNextIntro.setVisibility(View.VISIBLE);
                break;
            case 1:
            case 2:
                binding.tvBackIntro.setVisibility(View.VISIBLE);
                binding.tvNextIntro.setVisibility(View.VISIBLE);
                binding.tvBackIntro.setText(getString(R.string.back));
                break;
            case 3:
                binding.tvNextIntro.setVisibility(View.GONE);
                binding.tvBackIntro.setVisibility(View.VISIBLE);
                anime();
                break;
            default:

        }
    }


}