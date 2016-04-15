package com.arend_jan.streekmarkt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

public class Fotos extends AppCompatActivity{
    GalleryAdapter mAdapter;
    RecyclerView mRecyclerView;
    ArrayList<ImageModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        for (int i = 0; i < Namen.fotosA.length; i++) {
//  Adding images & title to POJO class and storing in Array (our data)
            ImageModel imageModel = new ImageModel();
            imageModel.setName(Namen.fotosA[i].getTitel());
            imageModel.setUrl(Namen.fotosA[i].getUrl());
            data.add(imageModel);
        }
        try {
            getSupportActionBar().setTitle(Namen.fotos);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }catch (Exception e){
            Log.d("adsf", e.getLocalizedMessage());
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.listie);
        mRecyclerView = (RecyclerView) findViewById(R.id.listie);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setHasFixedSize(true); // Helps improve performance
        mAdapter = new GalleryAdapter(Fotos.this, data);
        mRecyclerView.setAdapter(mAdapter);

        mRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this,
                new RecyclerItemClickListener.OnItemClickListener() {

                    @Override
                    public void onItemClick(View view, int position) {

                        Intent intent = new Intent(Fotos.this, DetailActivity.class);
                        intent.putParcelableArrayListExtra("data", data);
                        intent.putExtra("pos", position);
                        startActivity(intent);

                    }
                }));
    }
}
