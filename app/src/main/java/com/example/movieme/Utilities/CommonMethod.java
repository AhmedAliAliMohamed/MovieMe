package com.example.movieme.Utilities;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.movieme.R;

import java.util.Locale;

public class CommonMethod {

    public static String getLanguageId(Context context) {
        String language = SharedPreferenceHelper.getSharedPreferenceString(context,SharedPreferenceHelper.Keys.LANGUAGE_KEY.getValue(),Locale.getDefault().getLanguage());
        if (language.equalsIgnoreCase("ar")) {
            return "ar";
        }
        if (language.equalsIgnoreCase("en")) {
            return "en";
        }

        return " ";
    }


    public static void refreshScreen(Activity activity){
        activity.finishAffinity();
        activity.startActivity(activity.getIntent());
        activity.overridePendingTransition(R.anim.rotate_in, R.anim.rotate_out);
    }
}
