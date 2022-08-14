package com.example.movieme.Ui.ChangeLanguage;

import static com.example.movieme.Utilities.CommonMethod.getLanguageId;

import android.app.Dialog;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.example.movieme.App.LocalHelper;
import com.example.movieme.Base.BaseFragment;
import com.example.movieme.Base.BaseViewModel;
import com.example.movieme.R;
import com.example.movieme.Utilities.CommonMethod;
import com.example.movieme.Utilities.Events.DismissDialogEvent;
import com.example.movieme.Utilities.SharedPreferenceHelper;
import com.example.movieme.databinding.FragmentChangeLanguageBinding;

import org.greenrobot.eventbus.EventBus;

import java.util.Locale;


public class ChangeLanguageFragment extends BaseFragment {

    private FragmentChangeLanguageBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container
            , @Nullable Bundle savedInstanceState) {
        binding = FragmentChangeLanguageBinding.inflate(inflater, container, false);
        initListener();
        return binding.getRoot();
    }

    @Override
    public BaseViewModel getViewModel() {
        return null;
    }

    @Override
    public void initObservers() {

    }


    private void initListener() {
        binding.btnCancel.setOnClickListener(v -> {
            EventBus.getDefault().post(new DismissDialogEvent());
        });

        binding.btnOk.setOnClickListener(v -> {
            if (CommonMethod.getLanguageId(getActivity()).equalsIgnoreCase("en")) {
                SharedPreferenceHelper.setSharedPreferenceString(context, SharedPreferenceHelper.Keys.LANGUAGE_KEY.getValue(), SharedPreferenceHelper.Keys.AR.getValue());
            } else {
                SharedPreferenceHelper.setSharedPreferenceString(context, SharedPreferenceHelper.Keys.LANGUAGE_KEY.getValue(), SharedPreferenceHelper.Keys.EN.getValue());
            }
            LocalHelper.setLocal(context);
            refreshScreen();


        });
    }

    private void refreshScreen() {
        EventBus.getDefault().post(new DismissDialogEvent());
        getActivity().finishAffinity();
        context.startActivity(getActivity().getIntent());
        getActivity().overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);

    }


}

