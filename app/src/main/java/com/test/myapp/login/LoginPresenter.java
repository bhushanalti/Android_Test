package com.test.myapp.login;



public interface LoginPresenter {

    void login(String name, String password);
    void storeToken(String token);
}
