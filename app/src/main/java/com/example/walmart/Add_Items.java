package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class Add_Items extends AppCompatActivity {
    EditText itemName,itemDis,itemCat,itemPrice;
    Button AddItemButton;
    ImageView itemImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

        itemName=findViewById(R.id.et_item_name);
        itemDis=findViewById(R.id.et_item_dic);
        itemCat=findViewById(R.id.et_item_category);
        itemPrice=findViewById(R.id.et_item_price);
        AddItemButton=findViewById(R.id.add_product);
        itemImage=findViewById(R.id.add_Image);

    }
}