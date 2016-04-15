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

import java.util.ArrayList;

/*********
 * Adapter class extends with BaseAdapter and implements with OnClickListener
 ************/
public class menuAdapter extends BaseAdapter implements View.OnClickListener {

    /***********
     * Declare Used Variables
     *********/
    private Activity activity;
    private ArrayList data;
    private static LayoutInflater inflater = null;
    public Resources res;
    menuModel tempValues = null;
    int i = 0;

    /*************
     * CustomAdapter Constructor
     *****************/
    public menuAdapter(Activity a, ArrayList d, Resources resLocal) {

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
            vi = inflater.inflate(R.layout.menuitem, null);

            /****** View Holder Object to contain tabitem.xml file elements ******/

            holder = new ViewHolder();
            holder.Sort = (TextView) vi.findViewById(R.id.DocentW);
            holder.Image = (ImageView) vi.findViewById(R.id.imageView);



            /************  Set holder with LayoutInflater ************/
            vi.setTag(holder);
        } else
            holder = (ViewHolder) vi.getTag();


        /***** Get each Model object from Arraylist ********/
        tempValues = null;
        tempValues = (menuModel) data.get(position);

        /************  Set Model values in Holder elements ***********/

        holder.Sort.setText(tempValues.getSort());

        int image;
        boolean zwart = false;
        String vak = tempValues.getSort();
        switch (vak) {
            case Namen.kramen:
                zwart = true;
                image = Namen.kramenDraw;
                break;
            case Namen.evenementen:
                zwart = true;
                image = Namen.evenementenDraw;
                break;
            case Namen.fotos:
                image = Namen.fotosDraw;
                break;
            case Namen.geschiedenis:
                image = Namen.geschiedenisDraw;
                break;

            default:
                image = R.drawable.defimg;

        }
if(!zwart) {
    holder.Sort.setTextColor(Color.BLACK);
}
        else{
    holder.Sort.setTextColor(Color.WHITE);
        }

        holder.Image.setImageResource(image);


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
            Log.d("asdf", mPosition + "");
            Intent intent;
            switch (mPosition) {
                case 0:
                    intent = new Intent(a, Kramen.class);
                    a.startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(a, Evenementen.class);
                    a.startActivity(intent);
                    //Evenementen
                    break;
                case 2:
                    intent = new Intent(a, Fotos.class);
                    a.startActivity(intent);
                    //Foto'
                    break;
                case 3:
                    intent = new Intent(a, Geschiedenis.class);
                    a.startActivity(intent);
                    //Geschiedenis
                    break;
                default:
                    //Niets
                    break;
            }


        }
    }
}