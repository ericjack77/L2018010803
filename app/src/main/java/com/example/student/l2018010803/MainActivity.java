package com.example.student.l2018010803;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    /*
    String abc[]={"北","中","南","花東","金門"};
    String code[]={"02","04","06","08","10"};
    int img[]={R.drawable.tp,R.drawable.chu,R.drawable.tn,R.drawable.kou,R.drawable.tn,R.drawable.chu};
    */
    boolean cks[]=new boolean[8];
    ArrayList<Map<String,Object>> mylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HashMap<String,Object> m1=new HashMap<>();
        m1.put("city","台北");
        m1.put("code","02");
        m1.put("img",R.drawable.tp);
        mylist.add(m1);
        HashMap<String,Object> m2=new HashMap<>();
        m2.put("city","台中");
        m2.put("code","04");
        m2.put("img",R.drawable.chu);
        mylist.add(m2);
        HashMap<String,Object> m3=new HashMap<>();
        m3.put("city","台南");
        m3.put("code","04");
        m3.put("img",R.drawable.tn);
        mylist.add(m3);
        HashMap<String,Object> m4=new HashMap<>();
        m4.put("city","高雄");
        m4.put("code","06");
        m4.put("img",R.drawable.kou);
        mylist.add(m4);
        HashMap<String,Object> m5=new HashMap<>();
        m5.put("city","5台北");
        m5.put("code","052");
        m5.put("img",R.drawable.tp);
        mylist.add(m5);
        HashMap<String,Object> m6=new HashMap<>();
        m6.put("city","台6中");
        m6.put("code","064");
        m6.put("img",R.drawable.chu);
        mylist.add(m6);
        HashMap<String,Object> m7=new HashMap<>();
        m7.put("city","台7南");
        m7.put("code","074");
        m7.put("img",R.drawable.tn);
        mylist.add(m7);
        HashMap<String,Object> m8=new HashMap<>();
        m8.put("city","高雄");
        m8.put("code","06");
        m8.put("img",R.drawable.kou);
        mylist.add(m8);

        lv = (ListView) findViewById(R.id.listview);
        myadapter adapter = new myadapter();
        lv.setAdapter(adapter);


    }
    class myadapter extends BaseAdapter {

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
            Log.d("getView", "position: "+position);

            LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
            View v1 =inflater.inflate(R.layout.mylayout,null);

            TextView tv=v1.findViewById(R.id.textView);
            tv.setText(mylist.get(position).get("city").toString());
            TextView tv2=v1.findViewById(R.id.textView2);
            tv2.setText(mylist.get(position).get("code").toString());
            ImageView iv=v1.findViewById(R.id.imageView);
            iv.setImageResource((Integer) mylist.get(position).get("img"));

            CheckBox cb=v1.findViewById(R.id.checkBox);
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

    public void click1(View v)
    {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<cks.length;i++)
        {
            if(cks[i])
            {
                sb.append(mylist.get(i).get("city")+",");
            }
        }
        Toast.makeText(MainActivity.this, sb.toString(), Toast.LENGTH_LONG).show();



    }
}
