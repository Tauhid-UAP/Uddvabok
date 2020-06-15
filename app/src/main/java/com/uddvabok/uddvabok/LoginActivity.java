package com.uddvabok.uddvabok;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.uddvabok.uddvabok.R;

public class LoginActivity extends AppCompatActivity {
    private TextView signup_login;
    private Button login_login;
    private FirebaseAuth fAuth;
    private EditText u_user_email,u_user_psw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_login=(Button)findViewById(R.id.btn_login_login);
        signup_login=(TextView)findViewById(R.id.txt_signup_login);
        u_user_email=(EditText)findViewById(R.id.useremail);
        u_user_psw=(EditText)findViewById(R.id.userpsw);
        fAuth=FirebaseAuth.getInstance();
        login_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=u_user_email.getText().toString().trim();
                String password=u_user_psw.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    u_user_email.setError("Email Address  is Required");
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    u_user_psw.setError("Password  is Required");
                    return;
                }
                if(password.length()<6){
                    u_user_psw.setError("Password Must be 6 characters");
                    return;
                }
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LoginActivity.this,"Login is Successfully",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),DashboardActivity.class));
                        }
                        else{
                            Toast.makeText(LoginActivity.this,"Error"+task.getException(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signup_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegiActivity.class));
            }
        });
    }
}
