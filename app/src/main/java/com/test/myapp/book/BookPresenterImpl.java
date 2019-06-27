package com.test.myapp.book;

import android.content.Context;

import com.test.myapp.services.SharedPreferencesRepositoryImpl;

public class BookPresenterImpl implements BookPresenter, BookInteractor.onBookListener {


    private BookView bookView;
    private BookInteractorImpl bookInteractor;
    private Context context;

    public BookPresenterImpl(BookView bookView, Context context) {
        this.bookView = bookView;
        this.context = context;
        bookInteractor = new BookInteractorImpl();
    }


    @Override
    public void getBook() {
        SharedPreferencesRepositoryImpl pref = new SharedPreferencesRepositoryImpl(context);
        bookInteractor.onBook(pref.getToken(), this);
    }

    @Override
    public void success(Book book) {

    }

    @Override
    public void failure(String message) {

    }
}
