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
            // Reset StringBuilder for each button click
            StringBuilder s = new StringBuilder();

            // Check if any RadioButton is selected
            int selected = radioGroup.getCheckedRadioButtonId();
            if (selected == -1) {
                // No RadioButton selected, show a message
                Toast.makeText(this, "Please select a gender.", Toast.LENGTH_SHORT).show();
                title2.setText("Please select a gender.");
                return;
            }

            // Get selected RadioButton text
            gender = findViewById(selected);
            String value = gender.getText().toString();
            s.append("You have selected: ").append(value).append("\n");

            // Check if at least one CheckBox is selected
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
                // No CheckBox selected, show a message
                Toast.makeText(this, "Please select at least one item.", Toast.LENGTH_SHORT).show();
                title2.setText("Please select at least one course.");
                return;
            }

            // Display the final result in the TextView
            title2.setText(s.toString());
        });
    }
}
