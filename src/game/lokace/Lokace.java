package game.lokace;

import game.itemy.Item;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Lokace {

    protected String jmenoLokace;
    protected ArrayList<Item> itemyVLokaci;
    protected Lokace[] vychody;

    public String getJmenoLokace(){
        return jmenoLokace;
    }

    public String getItemyVLokaci(){
        return itemyVLokaci.toString();
    }

    public String getVychody(){
        return Arrays.toString(vychody);
    }

    public boolean odebratItem(Item item){
        return itemyVLokaci.remove(item);
    }

    public abstract String getPopisLokace();



}
