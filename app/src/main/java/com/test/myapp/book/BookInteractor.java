package com.test.myapp.book;

public interface BookInteractor {

    interface onBookListener {
        void success(Book book);

        void failure(String message);
    }

    void onBook(String token, onBookListener listener);
}
