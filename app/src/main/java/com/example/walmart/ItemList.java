package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.GridView;

import com.example.walmart.Helper.ItemListAdapter;
import com.example.walmart.model.Items;

import java.util.ArrayList;

public class ItemList extends AppCompatActivity {
    GridView gridView;
    ArrayList<Items> list;
    ItemListAdapter adapter =null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        init();

    }
    public void init(){
        gridView=findViewById(R.id.grid);
        list= new ArrayList<>();
        adapter= new ItemListAdapter(this,R.layout.activity_item_design,list);
        gridView.setAdapter(adapter);

        Cursor cursor=Add_Items.itemDBHelper.getData("SELECT * FROM FOOD ");
        list.clear();
        while (cursor.moveToNext()){
            int id =cursor.getInt(0);
            String I_name=cursor.getString(1);
            String I_price=cursor.getString(2);
            String I_dis=cursor.getString(3);
            byte[] I_image=cursor.getBlob(4);
            list.add(new Items(id,I_name,I_price,I_dis,I_image));
        }
        adapter.notifyDataSetChanged();
    }
}