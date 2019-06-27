package com.test.myapp.services;

import com.test.myapp.book.Book;
import com.test.myapp.login.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

// Retrofit interface to construct request url parameter
public interface ApiInterface {

    @FormUrlEncoded
    @POST("signin/")
    Call<LoginResponse> authenticate(@Field("username") String email, @Field("password") String password);

    @GET("book/")
    Call<Book> getBooks(@Query("Authorization") String token);
}
