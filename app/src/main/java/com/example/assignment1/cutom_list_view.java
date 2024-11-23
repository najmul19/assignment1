package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cutom_list_view extends AppCompatActivity {

    private ListView listView;
    private String[] Names;
    private int[] flags = {R.drawable.argentina, R.drawable.afganistan,R.drawable.armenia,R.drawable.azerbaijan,R.drawable.bahrain,R.drawable.bangladesh,R.drawable.butan,R.drawable.brazil,R.drawable.china,R.drawable.japan,R.drawable.nepal,R.drawable.pakistan,R.drawable.srilanka,};
    String[] subtitle ={
            "Sub Title 1","Sub Title 2",
            "Sub Title 3","Sub Title 4",
            "Sub Title 5", "Sub Title 6","Sub Title 7",
            "Sub Title 8","Sub Title 9",
            "Sub Title 10","Sub Title 11","Sub Title 12",
            "Sub Title 13",
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cutom_list_view);
        listView = findViewById(R.id.listViewId);
        Names = getResources().getStringArray(R.array.name);
        custom_adapter adapter = new custom_adapter(this,Names,subtitle,flags);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value=Names[position];
                Toast.makeText(cutom_list_view.this, value, Toast.LENGTH_SHORT).show();
            }
        });

    }
}