package com.test.myapp.login;



public interface LoginInteractor {

    interface onLoginListener{

        void onSuccess();
        void failure(String message);
        void onUserNameError();
        void onPasswordError();
        void storeToken(String token);
    }

    void onLogin(String username, String password, onLoginListener listener);

}
