package com.test.myapp.services;

public interface SharedPreferencesRepository {

    String getToken();

    void storeToken(String token);
}
