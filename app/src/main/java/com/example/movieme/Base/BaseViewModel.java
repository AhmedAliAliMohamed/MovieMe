package com.example.movieme.Base;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class BaseViewModel extends AndroidViewModel {
    public Context context;

    public BaseViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
    }
}
