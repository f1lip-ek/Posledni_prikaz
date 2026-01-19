package game.lokace;

import game.itemy.Item;
import java.util.ArrayList;
import java.util.Arrays;

public class Lokace {

    protected String id;
    protected String nazev;
    protected String popis;
    protected String[] idVychodu;
    protected Lokace[] vychody;
    protected ArrayList<String> items;
    protected ArrayList<Item> itemyVLokaci;
    protected boolean porazenyGolias;
    protected boolean kontrolaServeru;

    public Lokace() {
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

    public String[] getVychody(){
        return idVychodu;
    }

    public Item odebratItem(Item item){
        return itemyVLokaci.getFirst();
    }

    public String getId(){
        return id;
    }

    public void setItemyVLokaci(ArrayList<Item> vsechnyItemy){
        for (String item : items){
            for (int j = 0; j < vsechnyItemy.size(); j++) {
                if (item.equals(vsechnyItemy.get(j).getId())){
                    itemyVLokaci.add(vsechnyItemy.get(j));
                }
            }
        }
    }

    public void setVychody(ArrayList<Lokace> vsechnyLokace){
        vychody = new Lokace[idVychodu.length];
        for (int i = 0; i < idVychodu.length; i++) {
            for (int j = 0; j < vsechnyLokace.size(); j++) {
                if (idVychodu[i].equals(vsechnyLokace.get(j).getId())){
                    vychody[i] = vsechnyLokace.get(j);
                }
            }
        }
    }


    @Override
    public String toString() {
        return "Lokace{" +
                "id='" + id + '\'' +
                ", nazev='" + nazev + '\'' +
                ", popis='" + popis + '\'' +
                ", vychody=" + Arrays.toString(vychody) +
                ", \n items=" + items +
                ", itemyVLokaci=" + itemyVLokaci +
                ", porazenyGolias=" + porazenyGolias +
                ", kontrolaServeru=" + kontrolaServeru +
                '}';
    }
}
