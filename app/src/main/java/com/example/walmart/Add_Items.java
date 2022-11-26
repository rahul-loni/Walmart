package com.example.walmart;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.walmart.Helper.ItemDBHelper;

public class Add_Items extends AppCompatActivity {
    public static ItemDBHelper itemDBHelper;
    EditText itemName,itemDis,itemCat,itemPrice;
    Button AddItemButton;
    ImageView itemImage;

    final  int REQUEST_CODE_GALLERY=999;
    public static SQLiteOpenHelper sqLiteOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_items);

      init();

    }
    public void init(){
        itemName=findViewById(R.id.et_item_name);
        itemDis=findViewById(R.id.et_item_dic);
        itemCat=findViewById(R.id.et_item_category);
        itemPrice=findViewById(R.id.et_item_price);
        AddItemButton=findViewById(R.id.add_product);
        itemImage=findViewById(R.id.add_Image);


        AddItemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String iName=itemName.getText().toString().trim();
                String iPrice=itemPrice.getText().toString().trim();
                String iDis=itemDis.getText().toString().trim();
            }
        });

    }
}