package com.example.movieme.Utilities;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {

    public static void setSharedPreferenceString(Context context, String key, String value) {
        SharedPreferences settings = context.getSharedPreferences(Keys.PREF_FILE.getValue(), 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getSharedPreferenceString(Context context, String key, String defValue) {
        SharedPreferences settings = context.getSharedPreferences(Keys.PREF_FILE.getValue(), 0);
        return settings.getString(key, defValue);
    }

    public enum Keys{
    LANGUAGE_KEY("LANGUAGE_KEY"),
        AR("ar"),
        EN("en"),
        PREF_FILE("PREF_FILE");

    String value;

        public String getValue() {
            return value;
        }

        Keys(String value){this.value =value;}

    }
}
