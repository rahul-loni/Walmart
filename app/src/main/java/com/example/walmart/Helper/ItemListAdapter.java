package com.example.walmart.Helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.walmart.ItemList;
import com.example.walmart.R;
import com.example.walmart.model.Items;

import java.util.ArrayList;

public class ItemListAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Items> items;

    public ItemListAdapter(Context context, int layout, ArrayList<Items> items) {
        this.context = context;
        this.layout = layout;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtName,txtPrice,txtDis;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row=view;
        ViewHolder holder=new ViewHolder();
        if (row==null){
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE
            );
            row=inflater.inflate(layout,null);
            holder.txtName=(TextView) row.findViewById(R.id.nameDesign);
            holder.txtPrice=(TextView) row.findViewById(R.id.priceDesign);
            holder.txtDis=(TextView) row.findViewById(R.id.disDesign);
            holder.imageView=(ImageView) row.findViewById(R.id.imgDesign);
            row.setTag(holder);
        }else {
            holder=(ViewHolder) row.getTag();
        }
        Items item=items.get(i);

          holder.txtName.setText(item.getName());
          holder.txtPrice.setText(item.getPrice());
          holder.txtDis.setText(item.getDis());
          byte[] items_image=item.getImage();
        Bitmap bitmap= BitmapFactory.decodeByteArray(items_image,0,items_image.length);
        holder.imageView.setImageBitmap(bitmap);
        return row;
    }
}
