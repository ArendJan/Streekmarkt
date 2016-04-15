package com.arend_jan.streekmarkt;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Kramen extends AppCompatActivity {
    public ArrayList<kramenModel> CustomRooster = new ArrayList<kramenModel>();
    private ListView listView;
    kramenAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kramen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        listView =(ListView) findViewById(R.id.listViewKramen);

        for(String x : new String[]{Namen.vasteKramen,Namen.janmaat, Namen.smorenburg, Namen.detuinderijbloemen,Namen.specialeKramen, Namen.roemeens, Namen.frietmakers, "etc"}){
            final kramenModel sched = new kramenModel();

            sched.setSort(x);

            CustomRooster.add(sched);
        }
        Resources res = getResources();

        Activity CustomListView = this;
        /**************** Create Custom Adapter *********/
        adapter = new kramenAdapter(CustomListView, CustomRooster, res);
        listView.setAdapter(adapter);

    }

}
