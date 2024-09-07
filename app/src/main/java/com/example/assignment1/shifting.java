package com.example.assignment1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class shifting extends AppCompatActivity implements View.OnClickListener {

    private Button btnShiftleft, btnShiftRight;
    private ImageView imageView;
    private TextView textView;
    int cnt1=0,cnt2=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_shifting);

        btnShiftleft = findViewById(R.id.btnLeft);
        btnShiftRight = findViewById(R.id.btnRight);
        imageView = findViewById(R.id.ivShift);
        textView = findViewById(R.id.tvShow);
        btnShiftleft.setOnClickListener(this);
        btnShiftRight.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btnLeft) {
            ++cnt1;
            imageView.setImageResource(R.drawable.kavasaki);
            textView.setText("Kawasaki clicked " + cnt1 + " times");
        } if(v.getId()==R.id.btnRight){
            ++cnt2;
            imageView.setImageResource(R.drawable.sportsbike);
            textView.setText("SportsBike clicked " + cnt2 + " times");
        }
    }
}