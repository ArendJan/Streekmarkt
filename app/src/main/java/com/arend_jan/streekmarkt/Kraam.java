package com.arend_jan.streekmarkt;

import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Arrays;

public class Kraam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kraam);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView = (ImageView) findViewById(R.id.header);
        //toolbar.setLogo(R.drawable.evenement);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        TextView kraamtext = (TextView) findViewById(R.id.kraamTextView);

        Intent intent = getIntent();
        String kraamnaam = intent.getStringExtra(Namen.intentKraam);
        getSupportActionBar().setTitle(kraamnaam);


        maakText(kraamtext, kraamnaam);


        try{
            int index = Arrays.asList(Namen.namenArrayv).indexOf(kraamnaam);
            int image = Namen.drawArrayv[index];
            imageView.setImageResource(image);
        }catch (Exception e){
            imageView.setImageResource(R.drawable.defimg);
        }


    }

    private void maakText(TextView kraamtext, String kraamnaam) {
        String uit = "";
        try {
            int index = Arrays.asList(Namen.namenArrayv).indexOf(kraamnaam);
            uit = Namen.htmlArrayv[index];
        }catch (Exception e){
            uit= "<h1>Nog geen text voor deze kraam</h1>";
        }


        kraamtext.setText(Html.fromHtml(uit));
    }


}
