package com.arend_jan.streekmarkt;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Evenement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        int pos = getIntent().getIntExtra(Namen.intentEvenement,0);
        EvenementenObject object = Namen.evenementenArray[pos];
        getSupportActionBar().setTitle(object.getTitel());
        TextView textView = (TextView) findViewById(R.id.evenementText);
        textView.setText(Html.fromHtml(object.getText()));
        ImageView imageView = (ImageView) findViewById(R.id.evenementImageV);
        imageView.setImageResource(object.getImage());


    }

}
