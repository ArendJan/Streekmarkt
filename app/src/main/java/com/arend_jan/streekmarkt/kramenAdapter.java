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
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/*********
 * Adapter class extends with BaseAdapter and implements with OnClickListener
 ************/
public class kramenAdapter extends BaseAdapter implements View.OnClickListener {

    /***********
     * Declare Used Variables
     *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    kramenModel tempValues = null;
    int i = 0;

    /*************
     * CustomAdapter Constructor
     *****************/
    public kramenAdapter(Activity a, ArrayList d, Resources resLocal) {

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


        public TextView Sort;
        public ImageView Image;


    }

    /******
     * Depends upon data size called for each row , Create each ListView row
     *****/
    public View getView(int position, View convertView, ViewGroup parent) {

        View vi = convertView;
        ViewHolder holder;

        if (convertView == null) {

            /****** Inflate tabitem.xml file for each row ( Defined below ) *******/
            vi = inflater.inflate(R.layout.kramenitem, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.Sort = (TextView) vi.findViewById(R.id.kramenText);
            holder.Image = (ImageView) vi.findViewById(R.id.imageViewKramen);



            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();


        /***** Get each Model object from Arraylist ********/
        tempValues = null;
        tempValues = (kramenModel) data.get(position);

        /************  Set Model values in Holder elements ***********/

        holder.Sort.setText(tempValues.getSort());

        int image;
        //boolean zwart = false;
        String vak = tempValues.getSort();
        switch (vak) {
            case Namen.smorenburg:
                //zwart = true;
                image = Namen.smorenburgDraw;
                break;
            case Namen.janmaat:
                //zwart = true;
                image = Namen.janmaatDraw;
                break;
            case Namen.detuinderijbloemen:
                image = Namen.detuinderijloemenDraw;
                break;
            case "Geschiedenis":
                image = R.drawable.geschiedenis;
                break;

            default:
                image = R.drawable.defimg;

        }



        holder.Image.setImageResource(image);
        if(vak.equals(Namen.vasteKramen)|| vak.equals(Namen.specialeKramen)){
            holder.Image.setImageResource(android.R.color.transparent);
            holder.Image.setVisibility(View.GONE);
            if(Build.VERSION.SDK_INT>=23) {
                holder.Sort.setTextAppearance(android.R.style.TextAppearance_Medium);
            }else{
                holder.Sort.setTextAppearance(activity,android.R.style.TextAppearance_Medium);
            }
            LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(50, 5, 0, 5); // llp.setMargins(left, top, right, bottom);
        }

        /******** Set Item Click Listner for LayoutInflater for each row *******/

        vi.setOnClickListener(new OnItemClickListener( vak, position, activity));

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
        private String kraamnaam;
        private Activity a;

        OnItemClickListener(String vak, int position, Activity activity) {
            mPosition = position;kraamnaam=vak;a=activity;
        }

        @Override
        public void onClick(View arg0) {
                String data = kraamnaam;
            if(kraamnaam.equals(Namen.vasteKramen)||kraamnaam.equals(Namen.specialeKramen)){
                //do nothing
                return;
            }
            Intent intent = new Intent(a,Kraam.class );
            intent.putExtra(Namen.intentKraam, kraamnaam);
            a.startActivity(intent);
            return;


        }
    }
}