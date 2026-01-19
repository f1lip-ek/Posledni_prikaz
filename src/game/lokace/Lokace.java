package game.lokace;

import game.itemy.Item;
import java.util.ArrayList;

public abstract class Lokace {

    protected String id;

    protected String nazev;
    protected String popis;
    protected Lokace[] vychody;
    protected ArrayList<Item> itemyVLokaci;
    protected boolean porazenyGolias;
    protected boolean kontrolaServeru;

    public Lokace(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.itemyVLokaci = new ArrayList<>();
    }

    public String getNazev(){
        return nazev;
    }

    public String getPopis(){
        return popis;
    }

    public String getItemyVLokaci(){
        return itemyVLokaci.toString();
    }

    public Lokace[] getVychody(){
        return vychody;
    }

    public Item odebratItem(Item item){
        return itemyVLokaci.getFirst();
    }



}
