package com.example.assignment1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class check_box_radio_button extends AppCompatActivity {

    TextView title1, title2;
    CheckBox milk, sugar, water;
    Button btn1;
    RadioButton gender;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box_radio_button);
        title1 = findViewById(R.id.title1);
        title2 = findViewById(R.id.title2);
        milk = findViewById(R.id.milk);
        sugar = findViewById(R.id.sugar);
        water = findViewById(R.id.water);
        btn1 = findViewById(R.id.btn1);
        radioGroup = findViewById(R.id.radioGrp);

        btn1.setOnClickListener(v -> {

            StringBuilder s = new StringBuilder();


            int selected = radioGroup.getCheckedRadioButtonId();
            if (selected == -1) {

                Toast.makeText(this, "Please select a gender.", Toast.LENGTH_SHORT).show();
                title2.setText("Please select a gender.");
                return;
            }

            gender = findViewById(selected);
            String value = gender.getText().toString();
            s.append("You have selected: ").append(value).append("\n");

            if (milk.isChecked() || sugar.isChecked() || water.isChecked()) {
                if (milk.isChecked()) {
                    String val = milk.getText().toString();
                    s.append(val).append(" is selected\n");
                }
                if (sugar.isChecked()) {
                    String val = sugar.getText().toString();
                    s.append(val).append(" is selected\n");
                }
                if (water.isChecked()) {
                    String val = water.getText().toString();
                    s.append(val).append(" is selected\n");
                }
            } else {

                Toast.makeText(this, "Please select at least one item.", Toast.LENGTH_SHORT).show();
                title2.setText("Please select at least one course.");
                return;
            }

            title2.setText(s.toString());
            radioGroup.clearCheck();
            milk.setChecked(false);
            sugar.setChecked(false);
            water.setChecked(false);
        });
    }
}
