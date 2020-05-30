package com.uddvabok.uddvabok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uddvabok.uddvabok.R;

public class LoginActivity extends AppCompatActivity {
    private TextView signup_login;
    private Button login_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_login=(Button)findViewById(R.id.btn_login_login);
        signup_login=(TextView)findViewById(R.id.txt_signup_login);
        signup_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, com.uddvabok.uddvabok.RegiActivity.class);
                startActivity(intent);
            }
        });
    }
}
