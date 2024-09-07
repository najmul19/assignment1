package com.example.assignment1;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int cnt1 =0,cnt2=0;
    private Button btn, btnAdd,btnSub;
    private TextView textView;
    private EditText editText1, editText2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.button);
        btnAdd = findViewById(R.id.add);
        btnSub = findViewById(R.id.sub);
        editText1 = findViewById(R.id.etnumber1);
        editText2 = findViewById(R.id.etnumber2);

        textView = findViewById(R.id.tvLogin);
        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);



        btn.setOnClickListener(v -> {
            LayoutInflater inflater = getLayoutInflater();
            View customView = inflater.inflate(R.layout.custom_toast_layout,findViewById(R.id.customtoastid));//layout name and id
            Toast toast = new Toast(MainActivity.this);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM,0,0);
            toast.setView(customView);
            toast.show();
        });
//        loginBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ++cnt1;
//                textView.setText("Login Button Is Clicked! "+ cnt1+" times");
//            }
//        });
//        LogoutBtn.setOnClickListener(v -> {
//            ++cnt2;
//            textView.setText("Logout Button Is Clicked! "+cnt2+" times");
//        });
    }

    @Override
    public void onClick(View v) {

        try {
            String n1 = editText1.getText().toString();
            String n2 = editText2.getText().toString();

            double num1 = Double.parseDouble(n1);
            double num2 = Double.parseDouble(n2);

            if(v.getId()==R.id.add) {
                double sum = num1+num2;
                textView.setText("result: " + sum);
            }  if(v.getId()==R.id.sub) {
                double sub = num1-num2;
                textView.setText("result: " + sub);
            }
        }
        catch (Exception e){
            Toast.makeText(MainActivity.this,"Please enter number",Toast.LENGTH_SHORT).show();
        }



    }
}