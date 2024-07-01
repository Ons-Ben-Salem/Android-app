package com.example.app.Activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int[] mThumbIds;

    public ImageAdapter(Context c, int[] thumbIds) {
        mContext = c;
        mThumbIds = thumbIds;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // Crée une nouvelle ImageView pour chaque élément référencé par l'Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // Si elle n'est pas recyclée, instancie une nouvelle ImageView pour l'afficher
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        } else {
            imageView = (ImageView) convertView;
        }

        // Charge l'image dans ImageView
        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }
}
