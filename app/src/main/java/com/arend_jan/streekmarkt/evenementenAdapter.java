package com.arend_jan.streekmarkt;

/**
 * Created by Arend-Jan on 1-2-2016.
 ____  ____  _____ _      ____           _  ____  _
 /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*********
 * Adapter class extends with BaseAdapter and implements with OnClickListener
 ************/
public class evenementenAdapter extends BaseAdapter implements View.OnClickListener {

    /***********
     * Declare Used Variables
     *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    evenementenModel tempValues = null;
    int i = 0;

    /*************
     * CustomAdapter Constructor
     *****************/
    public evenementenAdapter(Activity a, ArrayList d, Resources resLocal) {

        /********** Take passed values **********/
        activity = a;
        data = d;
        res = resLocal;

        /***********  Layout inflator to call external xml layout () ***********/
        inflater = (LayoutInflater) activity.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    /********
     * What is the size of Passed Arraylist Size
     ************/
    public int getCount() {

        if (data.size() <= 0)
            return 1;
        return data.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    /*********
     * Create a holder Class to contain inflated xml file elements
     *********/
    public static class ViewHolder {


        public TextView TitelView;
        public ImageView Image;
        public TextView text;


    }

    /******
     * Depends upon data size called for each row , Create each ListView row
     *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.evenemenitem, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.TitelView = (TextView) vi.findViewById(R.id.evenementenTitel);
            holder.Image = (ImageView) vi.findViewById(R.id.evenemenImage);
            holder.text = (TextView) vi.findViewById(R.id.evenementenLText);


            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();


        /***** Get each Model object from Arraylist ********/
        tempValues = null;
        tempValues = (evenementenModel) data.get(position);

        /************  Set Model values in Holder elements ***********/

        holder.TitelView.setText(tempValues.getTitel());



        holder.Image.setImageResource(tempValues.getImage());
        holder.text.setText(tempValues.getText());


        /******** Set Item Click Listner for LayoutInflater for each row *******/

        vi.setOnClickListener(new OnItemClickListener(position, activity));

        return vi;
    }

    @Override
    public void onClick(View v) {

    }

    /*********
     * Called when Item click in ListView
     ************/
    private class OnItemClickListener implements View.OnClickListener {
        private int mPosition;
        private Activity a;

        OnItemClickListener(int position, Activity activity) {
            mPosition = position;a=activity;
        }

        @Override
        public void onClick(View arg0) {
            Intent intent = new Intent(a, Evenement.class);
            intent.putExtra(Namen.intentEvenement, mPosition);
            a.startActivity(intent);


        }
    }
}