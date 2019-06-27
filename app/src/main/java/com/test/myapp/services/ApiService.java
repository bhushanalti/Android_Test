package com.test.myapp.services;

import android.content.SharedPreferences;

import com.test.myapp.book.Book;
import com.test.myapp.book.BookInteractor;
import com.test.myapp.login.LoginInteractor;
import com.test.myapp.login.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to create service request using retrofit and construct the response object and pass result.
 *
 */
public class ApiService {

    private static final String BASE_URL = "http://13.70.7.71:8080/api/";

    private static HashMap map = new HashMap();

    private static ApiService apiService = null;

    public static ApiService getApiService() {

        if(apiService == null) {
            apiService = new ApiService();
        }

        return  apiService;
    }

    private ApiInterface getInterfaceService() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }

    public void login(final String username, String password, final LoginInteractor.onLoginListener listener){

        ApiInterface mApiService = this.getInterfaceService();
        Call<LoginResponse> mService = mApiService.authenticate(username, password);
        mService.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                if(response.isSuccessful()) {
                    LoginResponse mLoginObject = response.body();

                    map.put("token", mLoginObject.getToken());  // for this sample storing token temporly , it should be store securely.

                    listener.onSuccess();
                    listener.storeToken(mLoginObject.getToken());
                } else {
                    listener.failure("Unable to Login!!");
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                call.cancel();
             }
        });
    }

    public void getBook(final String token, final BookInteractor.onBookListener listener){

        ApiInterface mApiService = this.getInterfaceService();
        Call<Book> mService = mApiService.getBooks(token);
        mService.enqueue(new Callback<Book>() {
            @Override
            public void onResponse(Call<Book> call, Response<Book> response) {

                if(response.isSuccessful()) {
                    Book book = response.body();

                    listener.success(book);
                    System.out.println("book obj  " + book);

                } else {
                    listener.failure("Error!!");
                }
            }

            @Override
            public void onFailure(Call<Book> call, Throwable t) {
                call.cancel();
            }
        });
    }

  }
