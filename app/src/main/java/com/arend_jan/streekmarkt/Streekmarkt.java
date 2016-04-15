package com.arend_jan.streekmarkt;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/*
    Keystore:
    streekmarkt alles.


 */
public class Streekmarkt extends AppCompatActivity {
    public ArrayList<menuModel> CustomRooster = new ArrayList<menuModel>();
    private ListView listView;
    menuAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_streekmarkt);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        listView =(ListView) findViewById(R.id.fragmentListView);
        for(String x : new String[]{"Kramen", "Evenementen", "Foto's", "Geschiedenis"}) {
            final menuModel sched = new menuModel();

            sched.setSort(x);

            CustomRooster.add(sched);
        }
        Resources res = getResources();

        Activity CustomListView = this;
        /**************** Create Custom Adapter *********/
        adapter = new menuAdapter(CustomListView, CustomRooster, res);
        Log.d("asdfasdf", "äsdfasdfasdfa");

        listView.setAdapter(adapter);

        Log.d("adsfasdf", "ebadsf");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if(preferences.getBoolean("warning", true)) {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("warning", false);
            editor.apply();

            new AlertDialog.Builder(this)
                    .setTitle("Pas op!")
                    .setMessage("Dit is geen officiele van Streekmarkt Woerden, deze app is gemaakt voor een opdracht Informatica. Niet alle informatie klopt of is volledig in deze app. \nArend-Jan en Vincent")
                    .setPositiveButton("Oke", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            }
                    ).show();
        }
    }


}
