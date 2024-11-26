package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class home extends AppCompatActivity {

    private Button btnText, btnImage, btnCheckRadio, btnSeekSwitchRatting, formANdRegexValidation, btnCustomListView, btnExpandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize buttons
        btnText = findViewById(R.id.btntext);
        btnImage = findViewById(R.id.btnimage);
        btnCheckRadio = findViewById(R.id.btnCheckRadio);
        formANdRegexValidation = findViewById(R.id.btnFormRegex);
        btnSeekSwitchRatting = findViewById(R.id.btnSeekbarRatingBarSwitch);
        btnCustomListView = findViewById(R.id.btnCustomListViewId);
        btnExpandableListView = findViewById(R.id.btnExpandebleListViewId);

        // Set click listeners
        btnText.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, MainActivity.class);
            startActivity(intent);
        });

        btnImage.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, shifting.class);
            startActivity(intent);
        });

        btnCheckRadio.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, check_box_radio_button.class);
            startActivity(intent);
        });

        btnSeekSwitchRatting.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, seekBar.class);
            startActivity(intent);
        });

        formANdRegexValidation.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, RegexValidation.class);
            startActivity(intent);
        });

        btnCustomListView.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, cutom_list_view.class);
            startActivity(intent);
        });

        btnExpandableListView.setOnClickListener(v -> {
            Intent intent = new Intent(home.this, MyExpandableListView.class);
            startActivity(intent);
        });
    }
}
