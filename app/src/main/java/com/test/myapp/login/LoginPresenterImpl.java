package com.test.myapp.login;


import android.content.Context;

import com.test.myapp.services.SharedPreferencesRepositoryImpl;

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.onLoginListener {


    private LoginView loginView;
    private LoginInteractor loginInteractor;
    private Context context;

    public LoginPresenterImpl(LoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
        loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void login(String name, String password) {

        loginInteractor.onLogin(name,password,this);

    }

    @Override
    public void onSuccess() {

        if (loginView!=null)

         loginView.setNavigation();


    }

    @Override
    public void failure(String message) {
        if (loginView!=null)
        loginView.showMessage(message);

    }

    @Override
    public void onUserNameError() {
        if (loginView!=null)
        loginView.setUsernameError();

    }

    @Override
    public void onPasswordError() {
        if (loginView!=null)
        loginView.setPasswordError();
    }

    @Override
    public void storeToken(String token) {
        SharedPreferencesRepositoryImpl pref = new SharedPreferencesRepositoryImpl(context);
        pref.storeToken(token);
    }


}
