package com.example.student.l2018010803;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Student on 2018/1/9.
 */

public class myadapter extends BaseAdapter {

    ArrayList<Map<String, Object>> mylist = new ArrayList();
    boolean cks[] = new boolean[8];
    Context context;
    public myadapter(Context context,ArrayList<Map<String, Object>> mylist)
    {
        this.context=context;
        this.mylist = mylist;
    }

    @Override
    public int getCount() {
        return mylist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override //用getview抓的資料  每次出現在畫面都資料都要重新抓取
    public View getView(final int position, View view, ViewGroup viewGroup) {
        Log.d("getView", "position: " + position);

        LayoutInflater inflater = LayoutInflater.from(context);
        View v1 = inflater.inflate(R.layout.mylayout, null);

        TextView tv = v1.findViewById(R.id.textView);
        tv.setText(mylist.get(position).get("city").toString());
        TextView tv2 = v1.findViewById(R.id.textView2);
        tv2.setText(mylist.get(position).get("code").toString());
        ImageView iv = v1.findViewById(R.id.imageView);
        iv.setImageResource((Integer) mylist.get(position).get("img"));

        CheckBox cb = v1.findViewById(R.id.checkBox);
        cb.setChecked(cks[position]);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cks[position] = b;
            }
        });//創造一個ChangeListener把勾選過的位置記住

        return v1;
    }
}
