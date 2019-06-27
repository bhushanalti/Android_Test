package com.test.myapp.book;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.test.myapp.R;

public class BookActivity extends Activity implements BookView{

    private BookPresenter bookPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        bookPresenter = new BookPresenterImpl(this, this);

        bookPresenter.getBook();

      FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(BookActivity.this, CreateBook.class));
            }
        });
    }


    @Override
    public void showMessage(String message) {

    }
}
