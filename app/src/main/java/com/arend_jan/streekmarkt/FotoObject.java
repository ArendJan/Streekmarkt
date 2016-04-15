package com.arend_jan.streekmarkt;

/**
 * Created by Arend-Jan on 30-3-2016.
 * ____  ____  _____ _      ____           _  ____  _
 * /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 * | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 * | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 * \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */
public class FotoObject {
    String url = "";

    public FotoObject(String url, String titel, String text) {
        this.url = url;
        this.titel = titel;
        this.text = text;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    String titel = "";

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    String text = "";


}
