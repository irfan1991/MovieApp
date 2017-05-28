package com.andaratech.movieapp.config;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import com.andaratech.movieapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.andaratech.movieapp.R.id.view;

/**
 * Created by Asus on 27/05/2017.
 */

public class Adapter extends SimpleAdapter
{
    LayoutInflater inflater;
    Context context;
    ArrayList<HashMap<String,String>> arrayList;

    public Adapter(Context context, ArrayList<HashMap<String, String>> data, int resource,
                   String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;
        inflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);

        ImageView image = (ImageView) view.findViewById(R.id.img_image);
        Picasso.with(context)
                .load(Server.cover + arrayList.get(position).get("image"))
                .placeholder(R.drawable.no_image)
                .fit().centerCrop()
                .error(R.drawable.no_preview)
                .into(image);

        return view;
    }
}
