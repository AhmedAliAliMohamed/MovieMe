package com.example.movieme.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.airbnb.lottie.LottieAnimationView;
import com.example.movieme.Models.ViewPagerModel;
import com.example.movieme.R;

import java.util.List;


public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyHolder> {

    private Context context;
    private List<ViewPagerModel> viewPagerModelList;
    public ViewAdapter(Context context, List<ViewPagerModel> viewPagerModelList) {
        this.context = context;
        this.viewPagerModelList = viewPagerModelList;
    }

    @NonNull
    @Override
    public ViewAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_pager_intro,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.MyHolder holder, int position) {
        ViewPagerModel viewPagerModel = viewPagerModelList.get(position);
        holder.animationView.setAnimation(viewPagerModel.getAnimationView());
        holder.textViewIntro.setText(viewPagerModel.getTitleString());



    }

    @Override
    public int getItemCount() {
        return viewPagerModelList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private LottieAnimationView animationView;
        private TextView textViewIntro;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            animationView = itemView.findViewById(R.id.lottie_view_pager_item_intro);
            textViewIntro = itemView.findViewById(R.id.tv_intro);
        }
    }
}
