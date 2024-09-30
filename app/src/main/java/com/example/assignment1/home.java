package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class home extends AppCompatActivity {

    private Button btnText,btnImage,btnCheckRadio,btnSeekSwitchRatting,formANdRegexValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);

        btnText = findViewById(R.id.btntext);
        btnImage = findViewById(R.id.btnimage);
        btnCheckRadio = findViewById(R.id.btnCheckRadio);
        formANdRegexValidation = findViewById(R.id.btnFormRegex);

        btnSeekSwitchRatting = findViewById(R.id.btnSeekbarRatingBarSwitch);

        btnText.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
        btnImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, shifting.class);
            startActivity(intent);
        });
        btnCheckRadio.setOnClickListener(v -> {
            Intent intent = new Intent(this, check_box_radio_button.class);
            startActivity(intent);
        });
        btnSeekSwitchRatting.setOnClickListener(v -> {
            Intent intent = new Intent(this, seekBar.class);
            startActivity(intent);
        });

        formANdRegexValidation.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegexValidation.class);
            startActivity(intent);
        });

    }
}