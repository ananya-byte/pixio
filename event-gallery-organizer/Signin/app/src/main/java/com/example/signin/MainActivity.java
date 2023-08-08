package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.signin.face_recognition.FaceClassifier;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    public static HashMap<String, FaceClassifier.Recognition> registered = new HashMap<>();

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
        eventRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegistrationActivity.class);
                intent.putExtra("user_email",str);
                startActivity(intent);
            }
        });
        uploadImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
                intent.putExtra("user_email",str);
                startActivity(intent);
            }
        });
    }
}