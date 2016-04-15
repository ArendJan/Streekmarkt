package com.arend_jan.streekmarkt;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class Evenementen extends AppCompatActivity {
    public ArrayList<evenementenModel> CustomRooster = new ArrayList<evenementenModel>();
    private ListView listView;
    evenementenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenementen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView = (ListView) findViewById(R.id.evenementenListView);
        for(EvenementenObject evenement : Namen.evenementenArray){
            String naam = evenement.getTitel();
            String textSmall = evenement.getSmalText();
            int image = evenement.getImage();
            final evenementenModel sched = new evenementenModel();

            sched.setText(textSmall);
            sched.setTitel(naam);
            sched.setImage(image);

            CustomRooster.add(sched);


        }
        Resources res = getResources();

        Activity CustomListView = this;
        /**************** Create Custom Adapter *********/
        adapter = new evenementenAdapter(CustomListView, CustomRooster, res);
        listView.setAdapter(adapter);

    }


}
