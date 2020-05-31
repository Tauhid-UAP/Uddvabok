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
import com.uddvabok.uddvabok.LoginActivity;
import com.uddvabok.uddvabok.R;

public class RegiActivity extends AppCompatActivity {
    private Button register_regi;
    private EditText u_cmpny_name,u_user_full_name,u_email,u_psw,u_cnf_psw,u_contact,u_address,u_usernane;
    private TextView login_regi;
    private FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register_regi=(Button)findViewById(R.id.btn_register_regi);
        login_regi=(TextView)findViewById(R.id.txt_login_register);
        u_cmpny_name=(EditText)findViewById(R.id.companyNameEditText);
        u_user_full_name=(EditText)findViewById(R.id.nameEditText);
        u_email=(EditText)findViewById(R.id.emailAddressEditText);
        u_psw=(EditText)findViewById(R.id.passwordEditText);
        u_cnf_psw=(EditText)findViewById(R.id.confirmPasswordEditText);
        u_contact=(EditText)findViewById(R.id.contactEditText);
        u_address=(EditText)findViewById(R.id.addressEditText);
        u_usernane=(EditText)findViewById(R.id.usernameEditText);

        fAuth=FirebaseAuth.getInstance();
        if (fAuth.getCurrentUser()!=null){
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }

        register_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String company=u_cmpny_name.getText().toString().trim();
                String full_name=u_user_full_name.getText().toString().trim();
                String email=u_email.getText().toString().trim();
                String password=u_psw.getText().toString().trim();
                String confirmed_password=u_cnf_psw.getText().toString().trim();
                String contact=u_contact.getText().toString().trim();
                String address=u_address.getText().toString().trim();
                String username=u_usernane.getText().toString().trim();

                if(TextUtils.isEmpty(company)){
                    u_cmpny_name.setError("Company name is Required");
                    return;
                }
                if(TextUtils.isEmpty(full_name)){
                    u_user_full_name.setError("Your name  is Required");
                    return;
                }
                if(TextUtils.isEmpty(email)){
                    u_email.setError("Email id is Required");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    u_psw.setError("Password  is Required");
                    return;
                }
                if(password.length()<6){
                    u_psw.setError("Password Must be 6 characters");
                    return;
                }
                if(TextUtils.isEmpty(confirmed_password)){
                    u_cnf_psw.setError("Confirmed Password  is Required");
                    return;
                }
                if(confirmed_password.length()<6) {
                    u_cnf_psw.setError("Confirmed Password Must be 6 characters");
                    return;
                }

                    if(!password.equals(confirmed_password)){
                        Toast.makeText(RegiActivity.this,"Password Not match",Toast.LENGTH_SHORT).show();
                    }
                if(TextUtils.isEmpty(contact)){
                    u_contact.setError("Contact Number is Required");
                    return;
                }
                if(TextUtils.isEmpty(address)){
                    u_address.setError("Your Address is Required");
                    return;
                }
                if(TextUtils.isEmpty(username)){
                    u_usernane.setError("User Name   is Required");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(RegiActivity.this,"User Created ",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(RegiActivity.this," Error ! ! "+task.getException().getMessage(),Toast.LENGTH_SHORT).show();

                        }
                    }
                });

            }
        });


        login_regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegiActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
