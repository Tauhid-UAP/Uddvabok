package com.uddvabok.uddvabok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.uddvabok.uddvabok.LoginActivity;
import com.uddvabok.uddvabok.R;

public class RegiActivity extends AppCompatActivity {
    private Button register_regi;
    private TextView login_regi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_regi=(Button)findViewById(R.id.btn_register_regi);
        login_regi=(TextView)findViewById(R.id.txt_login_register);
        login_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegiActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
