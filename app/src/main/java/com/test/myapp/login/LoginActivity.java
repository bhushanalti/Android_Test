package com.test.myapp.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.myapp.R;
import com.test.myapp.book.BookActivity;


public class LoginActivity extends Activity implements LoginView{


    EditText user_name, password;
    Button login;
    LoginPresenter loginpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        loginpresenter = new LoginPresenterImpl(this, this);
        user_name = (EditText) findViewById(R.id.username);
        password= (EditText) findViewById(R.id.password);
        login= (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               loginpresenter.login(user_name.getText().toString(),password.getText().toString());
            }
        });
    }


    @Override
    public void setUsernameError() {
        user_name.setError("Username Empty");
    }

    @Override
    public void setPasswordError() {
        password.setError("password Empty");
    }

    @Override
    public void setNavigation() {

        startActivity(new Intent(LoginActivity.this, BookActivity.class));

    }

    @Override
    public void showMessage(String message) {

        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }
}
