package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    TextView userDetails ;
    Button eventRegister, uploadImages , viewImages;
    ImageButton logoutButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        String str = intent.getStringExtra("user_email");
        userDetails = findViewById(R.id.user_details);
        userDetails.setText(str);

        eventRegister = findViewById(R.id.event_register_button);
        uploadImages = findViewById(R.id.upload_images_button);
        viewImages = findViewById(R.id.view_images_button);

        logoutButton = findViewById(R.id.logout_button);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}