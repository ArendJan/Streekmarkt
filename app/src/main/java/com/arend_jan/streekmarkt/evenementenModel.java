package com.arend_jan.streekmarkt;

/**
 * Created by Arend-Jan on 1-2-2016.
 ____  ____  _____ _      ____           _  ____  _
 /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */
public class evenementenModel {

    private  String Titel="";
    private String Text = "";
    private int Image = R.drawable.defimg;
    public void setTitel(String titel) {
        Titel = titel;
    }

    public void setImage(int image) {
        Image = image;
    }

    public void setText(String text) {
        Text = text;
    }

    public String getTitel() {
        return Titel;
    }

    public String getText() {
        return Text;
    }

    public int getImage() {
        return Image;
    }
}
