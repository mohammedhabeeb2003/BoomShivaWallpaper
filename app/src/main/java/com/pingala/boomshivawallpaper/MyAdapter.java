package com.pingala.boomshivawallpaper;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.etsy.android.grid.util.DynamicHeightImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Habeeb on 2/6/2017.
 */

public class MyAdapter /*extends ArrayAdapter*/ {

   /* ArrayList<Images> mImageList;
    int resource;
    Context context;
    LayoutInflater li;
    ViewHolder holder;

    public MyAdapter(Context context, int resource,ArrayList<Images> mImageList) {

        super(context, resource,mImageList);

        this.context = context;
        this.resource = resource;
        this.mImageList = mImageList;
        li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        holder = new ViewHolder();
        if(v==null){
            v = li.inflate(resource,null);
           holder.img = (DynamicHeightImageView)v.findViewById(R.id.imgView);
           *//* holder.img = (ImageView) v.findViewById(R.id.imgView);*//*
            Glide.with(context).load(mImageList.get(position).getImg()).into(holder.img);
            v.setTag(holder);
        }
        else{

            holder =(ViewHolder)v.getTag();


        }
        return v;
    }

    static class ViewHolder{

        DynamicHeightImageView img;
      *//*  ImageView img;*//*


    }*/
}
