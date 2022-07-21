package com.example.movieme.Utilities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.movieme.Base.BaseFragment;
import com.example.movieme.Utilities.Events.DismissDialogEvent;
import com.example.movieme.databinding.OpenDialogLayoutBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class DialogHelper extends DialogFragment {
    private static final String TAG = "DialogHelperTag";
    private OpenDialogLayoutBinding binding;
    private BaseFragment baseFragment;


    public DialogHelper(BaseFragment baseFragment, FragmentManager fragmentManager) {
        this.baseFragment = baseFragment;
        show(fragmentManager,TAG);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        binding = OpenDialogLayoutBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        startFragment(baseFragment);

    }

    private void startFragment(BaseFragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(binding.flContainer.getId(), fragment);
        transaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

   @Subscribe
    public void dismissDialogEvent(DismissDialogEvent event){
        dismiss();
   }
}
