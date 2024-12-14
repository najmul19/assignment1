package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyExpandableListView extends AppCompatActivity {

    ListView listView;
    ArrayList<String> titles;
    ArrayList<String> descriptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_expandable_list_view);

        listView = findViewById(R.id.listViewExpandedId);

        // Dummy data
        titles = new ArrayList<>();
        descriptions = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            titles.add("Title " + i);
            descriptions.add("This is description " + i);
        }

        MyAdapter myAdapter = new MyAdapter(this, titles, descriptions);
        listView.setAdapter(myAdapter);
    }

    private class MyAdapter extends BaseAdapter {

        Context context;
        ArrayList<String> titles;
        ArrayList<String> descriptions;
        LayoutInflater layoutInflater;

        public MyAdapter(Context context, ArrayList<String> titles, ArrayList<String> descriptions) {
            this.context = context;
            this.titles = titles;
            this.descriptions = descriptions;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titles.size();
        }

        @Override
        public Object getItem(int position) {
            return titles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.sample_expandeble_layout, parent, false);
            }

            LinearLayout motherLayout = convertView.findViewById(R.id.motherLayout);
            RelativeLayout itemClicked = convertView.findViewById(R.id.itemClicked);
            ImageView arrowImg = convertView.findViewById(R.id.arrowImg);
            LinearLayout discLayout = convertView.findViewById(R.id.discLayout);
            TextView titleText = convertView.findViewById(R.id.titleText);
            TextView descriptionText = convertView.findViewById(R.id.descriptionText);

            titleText.setText(titles.get(position));
            descriptionText.setText(descriptions.get(position));

            itemClicked.setOnClickListener(v -> {
                if (discLayout.getVisibility() == View.GONE) {
                    TransitionManager.beginDelayedTransition(motherLayout, new AutoTransition());
                    discLayout.setVisibility(View.VISIBLE);
                    motherLayout.setBackgroundColor(Color.parseColor("#724CAF50"));
                    arrowImg.setImageResource(R.drawable.ic_up_draw);
                } else {
                    TransitionManager.beginDelayedTransition(motherLayout, new AutoTransition());
                    discLayout.setVisibility(View.GONE);
                    motherLayout.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    arrowImg.setImageResource(R.drawable.ic_down_arrow);
                }
            });

            return convertView;
        }
    }
}
