package com.example.pixio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class ViewActivity extends AppCompatActivity {
    ImageView imageView;
    TextView userDetails, registrationText;
    ImageButton homeButton;
    HashMap <String, Uri> finalupload = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        finalupload = MainActivity.userimg;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        registrationText = findViewById(R.id.reg_text);
        imageView = findViewById(R.id.reg_profile);
        userDetails = findViewById(R.id.user_details);
        homeButton =  findViewById(R.id.home_button);
        Intent intent = getIntent();
        String str = intent.getStringExtra("user_email");
        userDetails.setText(str);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        if(finalupload==null)
        {
            registrationText.setText("Picture not Uploaded");
        }
        else {
            imageView.setImageURI(finalupload.get(MainActivity.userreg));
            registrationText.setText(MainActivity.userreg);
        }
    }
}