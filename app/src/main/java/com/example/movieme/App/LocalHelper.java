package com.example.movieme.App;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.util.Log;

import com.example.movieme.Utilities.SharedPreferenceHelper;

import java.util.Locale;

public class LocalHelper {

public static Context setLocal(Context context){
    String lang = SharedPreferenceHelper.getSharedPreferenceString(context,SharedPreferenceHelper.Keys.LANGUAGE_KEY.getValue(), Locale.getDefault().getLanguage());
    return updateResources(context,lang);

}

    private static Context updateResources(Context context, String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        context.getResources().updateConfiguration(config,
                context.getResources().getDisplayMetrics());
        return context;
    }

}
