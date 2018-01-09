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
    boolean cks[];
    Context context;  //使用context連結主頁面
    public myadapter(Context context,ArrayList<Map<String, Object>> mylist,boolean cks[])
    {
        this.context=context;
        this.mylist = mylist;
        this.cks=cks;
    }//藉由子類別的建構子繼承父類別的資料

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
    public View getView(final int position, View v1, ViewGroup viewGroup) {
        viewholder viewholder;
        if(v1==null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v1 = inflater.inflate(R.layout.mylayout, null);
            viewholder=new viewholder();
            viewholder.tv = v1.findViewById(R.id.textView);
            viewholder.tv2 = v1.findViewById(R.id.textView2);
            viewholder.iv = v1.findViewById(R.id.imageView);
            viewholder.cb = v1.findViewById(R.id.checkBox);
            v1.setTag(viewholder);
        }
        else
        {
            viewholder=(viewholder) v1.getTag();
        }


        viewholder.tv.setText(mylist.get(position).get("city").toString());
        viewholder.tv2.setText(mylist.get(position).get("code").toString());
        viewholder.iv.setImageResource((Integer) mylist.get(position).get("img"));

        viewholder.cb.setOnCheckedChangeListener(null);
        viewholder.cb.setChecked(cks[position]);
        viewholder.cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                cks[position] = b;
            }
        });//創造一個ChangeListener把勾選過的位置記住



        return v1;
    }
    static class viewholder
    {
        TextView tv;
        TextView tv2;
        ImageView iv;
        CheckBox cb;
    }
}
