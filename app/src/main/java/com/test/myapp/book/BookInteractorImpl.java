package com.test.myapp.book;

import com.test.myapp.services.ApiService;

public class BookInteractorImpl implements BookInteractor {

    @Override
    public void onBook(String token, onBookListener listener) {

        ApiService apiService = ApiService.getApiService();

        apiService.getBook(token, listener);

    }
}
