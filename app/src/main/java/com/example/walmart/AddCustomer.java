package com.example.walmart;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.walmart.Helper.CustomerDBHelper;
import com.example.walmart.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddCustomer extends AppCompatActivity {
    EditText cName,cAdd;
    ImageView cImage;
    Button cAddBtn;
    public static CustomerDBHelper customerDBHelper;
    final int REQUEST_CODE_GALLERY=999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_customer);
         init();
         customerDBHelper= new CustomerDBHelper(this,"CustomerDB.sqlite"
                 ,null,1);
         customerDBHelper.queryData("CREATE TABLE IF NOT EXISTS CUSTOMER " +
                 "(ID INTEGER KEY AUTOINCREMENT , name VARCHAR , price VARCHAR , image BLOG)");

         cAdd.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 ActivityCompat.requestPermissions(
                         AddCustomer.this,
                         new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                         REQUEST_CODE_GALLERY
                 );
             }
         });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==REQUEST_CODE_GALLERY){
            if (grantResults.length >0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Intent intent=new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(this, "Not Permission", Toast.LENGTH_SHORT).show();
            }return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == REQUEST_CODE_GALLERY && resultCode == RESULT_OK && data != null){
            Uri uri = data.getData();

            try {
                InputStream inputStream = getContentResolver().openInputStream(uri);

                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                cImage.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    public void init(){
        cName=findViewById(R.id.C_name);
        cAdd=findViewById(R.id.C_add);
        cImage=findViewById(R.id.C_image);
        cAddBtn=findViewById(R.id.addCustomer);
    }
}