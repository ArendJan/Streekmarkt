package com.arend_jan.streekmarkt;

/**
 * Created by Arend-Jan on 27-3-2016.
 * ____  ____  _____ _      ____           _  ____  _
 * /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 * | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 * | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 * \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */
public class EvenementenObject {
    public String smalText = "";
    public String text = "";
    public int image = R.drawable.defimg;
    public String titel = "";

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int num = 0;
    public EvenementenObject(String x, String y, String z,int asdf, int lel ){
        this.titel = x;
        this.smalText = y;
        this.text = z;
        this.image=asdf;
        this.num = lel;
    }
    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }



    public String getSmalText() {
        return smalText;
    }

    public void setSmalText(String smalText) {
        this.smalText = smalText;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
