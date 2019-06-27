package com.test.myapp.login;

import android.text.TextUtils;

import com.test.myapp.services.ApiService;


public class LoginInteractorImpl implements LoginInteractor {



    @Override
    public void onLogin(String username, String password, onLoginListener listener) {

        if (TextUtils.isEmpty(username)){

            listener.onUserNameError();
        } else if (TextUtils.isEmpty(password)){

            listener.onPasswordError();
        }else {

            ApiService apiService = ApiService.getApiService();

            apiService.login(username, password, listener);

           // listener.onSuccess();
        }/*else {

            listener.failure("Something ent wrong");
        }*/

    }

}
