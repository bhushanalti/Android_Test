package com.test.myapp.services;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * class to create shared preference and store token temporarily. this class only created for demo purpose. Actually
 * it should be stored in secure format.
 */
public class SharedPreferencesRepositoryImpl implements SharedPreferencesRepository {

    private SharedPreferences prefs;

    public SharedPreferencesRepositoryImpl(Context context) {

        prefs = context.getSharedPreferences("MyPref", 0);

    }

    @Override
    public String getToken() {
        return prefs.getString("Token", "");
    }

    @Override
    public void storeToken(String token) {
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("Token", token);
        editor.commit();
    }
}
