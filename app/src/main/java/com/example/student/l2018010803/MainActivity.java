package com.example.student.l2018010803;

import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
            View v1 =inflater.inflate(R.layout.mylayout,null);

            TextView tv=v1.findViewById(R.id.textView);
            tv.setText(mylist.get(position).get("city").toString());
            TextView tv2=v1.findViewById(R.id.textView2);
            tv2.setText(mylist.get(position).get("code").toString());
            ImageView iv=v1.findViewById(R.id.imageView);
            iv.setImageResource((Integer) mylist.get(position).get("img"));

            return v1;
        }
    }
}
