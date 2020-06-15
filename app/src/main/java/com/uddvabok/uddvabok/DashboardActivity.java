package com.uddvabok.uddvabok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.net.Authenticator;

public class DashboardActivity extends AppCompatActivity {
    private FirebaseAuth fAuth;

    private TextView dashboard_wlcm_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        fAuth.getCurrentUser();
        dashboard_wlcm_txt=(TextView)findViewById(R.id.dashboard_wlc);
        dashboard_wlcm_txt.setText("Welcome to Dash");

    }
}