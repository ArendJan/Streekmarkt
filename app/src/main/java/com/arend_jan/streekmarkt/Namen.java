package com.arend_jan.streekmarkt;


/**
 * Created by Arend-Jan on 24-3-2016.
 * ____  ____  _____ _      ____           _  ____  _
 * /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 * | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 * | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 * \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */
public class Namen {
    public static final String smorenburg = "Smorenburg Fruit";
    public static final String janmaat = "Janmaat Kaas";
    public static final String detuinderijbloemen = "De Tuinderij Bloemen";
    public static final String vasteKramen = "Vaste Kramen:";
    public static final String specialeKramen = "Speciale Kramen:";

    public static final String smorenburgHtml = "Smorenburg Fruit is een teler uit het mooie Montfoort. Ariën Smorenburg verbouwd onder andere:<br> • Peren<br>• Appels<br>• Kersen<br>• Pruimen<br>En dat allemaal op een verantwoorde en lekkere manier.<br><br><b>Bewust Op Smaak Geteeld</b>";
    public static final String janmaatHtml ="Janmaat Kaas maakt heerlijke kazen van hun eigen melk op Barwoutswaarder.<br><br><b>Contact</b><br>Telefoon:0348 - 123456";
    public static final String detuinderijloemenHtml = "De Tuinderij, van Familie de Jong, verkoopt allerlei seizoensgebonden bloemen en prachtige samengestelde boeketten.<br><b>Contact</b><br>Gijs: 06-25 22 30 38<br>Email: <a href=\"mailto:gijsdejong@hetnet.nl\">gijsdejong@hetnet.nl</a> ";

    public static final String geschiedenis ="Geschiedenis";
    public static final String fotos = "Foto's";
    public static final String kramen = "Kramen";
    public static final String evenementen = "Evenementen";

    public static final int smorenburgDraw = R.drawable.smorenburg;
    public static final int janmaatDraw = R.drawable.janmaat;
    public static final int detuinderijloemenDraw = R.drawable.detuinenbloemen;
    public static final int evenementenDraw = R.drawable.evenement;
    public static final int kramenDraw = R.drawable.markt;
    public static final int geschiedenisDraw = R.drawable.geschiedenis;
    public static final int fotosDraw = R.drawable.fotos;

    public static final String intentKraam = "kraamnaam";
    public static final String intentEvenement = "evenementnum";
    public static final String roemeens = "Roemeens eten";
    public static final String frietmakers = "Frietmakers";

    public static final String[] namenArrayv = {janmaat, smorenburg,detuinderijbloemen};
    public static final int[] drawArrayv={janmaatDraw, smorenburgDraw, detuinderijloemenDraw};
    public static final String[] htmlArrayv ={janmaatHtml, smorenburgHtml,detuinderijloemenHtml};


    public static final EvenementenObject[] evenementenArray= {new EvenementenObject("Paasmarkt","Aanstaande 26 maart is er weer Paarmarkt met een Paashaas, extra kramen en veel meer!","Aanstaande 26 maart is er weer Paarmarkt met een Paashaas, extra kramen en veel meer!<br><br>Wat er dit jaar is:<br> • Paashaas<br> • Dierenstal(lammetjes en schapen)<br> • Eiren verven<br> • Extra kramen(o.a. aardbeien, sieraden, etc)<br> • Nog meer<br><br>", R.drawable.paasmarkt,0),
            new EvenementenObject("Kerstmarkt", "Net als voorgaande jaren is er weer een kerstmarkt op het Kerkplein.", "Some text.", R.drawable.kerstmarkt,1)};

    public static final FotoObject[] fotosA = {new FotoObject("http://www.streekmarkt-woerden.nl/images/spandoek.JPG", "Spandoek", "Spandoek"), new FotoObject("http://www.streekmarkt-woerden.nl/images/fruitteler%20smorenburg%20-%20kopie.JPG","Boomgaard", "Ariën Smorenburg in zijn boomgaard."), new FotoObject("http://www.streekmarkt-woerden.nl/images/fruittuindeooievaar.JPG", "Fruittuin de Ooievaar","Fruittuin de Ooievaar."), new FotoObject("http://www.streekmarkt-woerden.nl/images/Hoeve%20Rietveld.JPG","Hoeve Rietveld", "De Jams van Hoeve Rietveld"), new
            FotoObject("http://www.streekmarkt-woerden.nl/images/de%20tuinderij.JPG","De Tuinderij", "Het brede aanbod van de Tuinderij"), new FotoObject("https://scontent-ams3-1.xx.fbcdn.net/hphotos-xpt1/t31.0-8/12901461_942854732478601_6547751407425144780_o.jpg","Janmaat", "De kaas van Janmaat!")};

}
