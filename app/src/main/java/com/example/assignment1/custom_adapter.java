package com.example.assignment1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class custom_adapter extends BaseAdapter {

    int[] flags;
    String[] Names;
    Context context;
    String[] subtitle;
    private LayoutInflater inflater;
    custom_adapter(Context context, String[] Names ,String[] subtitle, int[] flags){
        this.context=context;
        this.Names=Names;
        this.flags=flags;
        this.subtitle=subtitle;

    }
    @Override
    public int getCount() {
        return Names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.sample_layout_list_view, parent, false);

        }
        ImageView imageView= convertView.findViewById(R.id.imageViewId);
        TextView textView1 = convertView.findViewById(R.id.titleId);
        TextView textView2 = convertView.findViewById(R.id.subtitleId);


        imageView.setImageResource(flags[position]);
        textView1.setText(Names[position]);
        textView2.setText(subtitle[position]);


        return convertView;
    }
}
