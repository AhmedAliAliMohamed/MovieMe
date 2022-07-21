package com.example.movieme.Models;

import com.airbnb.lottie.LottieAnimationView;

public class ViewPagerModel {

    private int animationView;
    private String titleString ;

    public int getAnimationView() {
        return animationView;
    }

    public String getTitleString() {
        return titleString;
    }

    public ViewPagerModel(int animationView, String titleString) {
        this.animationView = animationView;
        this.titleString = titleString;
    }
}
