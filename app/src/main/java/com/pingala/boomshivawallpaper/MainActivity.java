package com.pingala.boomshivawallpaper;

import android.app.ProgressDialog;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.etsy.android.grid.StaggeredGridView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    StaggeredGridView mGridView;
  /*  GridView mGridView;*/
    FirebaseDatabase database;
    DatabaseReference mRef;
    StaggeredGridLayoutAdapter adapter;
    StaggeredGridLayoutManager  mLayoutManager;
    private RecyclerView recyclerViewMain;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /*   imageView = (ImageView)findViewById(R.id.imgView);*/
       /*mGridView =(StaggeredGridView)findViewById(R.id.grid_view);*/
        recyclerViewMain = (RecyclerView) findViewById(R.id.my_recycler_view);

        new ImageTask().execute();


    }

    class ImageTask extends AsyncTask<Void,Void,Void>{
        ArrayList<String> mImageList;
        ProgressDialog pd;
        MyAdapter ma;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pd = new ProgressDialog(MainActivity.this);
            pd.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            database = FirebaseDatabase.getInstance();
            mRef = database.getReferenceFromUrl("https://boom-shiva-wallpapers.firebaseio.com");

            mRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    mImageList = new ArrayList();
                    for(DataSnapshot data: dataSnapshot.getChildren()){

                        String img = data.child("thumbnailUrl").getValue(String.class);
                        /*Images im = new Images(img);*/
                        mImageList.add(img);
                    }
                    recyclerViewMain.setHasFixedSize(true);
                    mLayoutManager = new StaggeredGridLayoutManager(2, GridLayoutManager.VERTICAL);
                    recyclerViewMain.setLayoutManager(mLayoutManager);
                    adapter = new StaggeredGridLayoutAdapter(MainActivity.this, mImageList);
                    recyclerViewMain.setAdapter(adapter);

                    Log.e("List",""+mImageList.size()+mImageList.get(0));
                    pd.dismiss();
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
