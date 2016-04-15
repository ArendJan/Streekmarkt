package com.arend_jan.streekmarkt;

/**
 * Created by Arend-Jan on 1-2-2016.
 ____  ____  _____ _      ____           _  ____  _
 /  _ \/  __\/  __// \  /|/  _ \         / |/  _ \/ \  /|
 | / \||  \/||  \  | |\ ||| | \|_____    | || / \|| |\ ||
 | |-|||    /|  /_ | | \||| |_/|\____\/\_| || |-||| | \||
 \_/ \|\_/\_\\____\\_/  \|\____/      \____/\_/ \|\_/  \|
 */
public class menuModel {

    private  String Sort="";

    /*********** Set Methods ******************/




public void setSort(String sort){
    this.Sort = sort;
}

    /*********** Get Methods ****************/
    public String getSort(){return this.Sort;}

}
