package game.lokace;

import game.itemy.Item;
import java.util.ArrayList;

/**
 * Trida ktera slouzi jako sablona ke vsem lokacim
 */
public class Lokace {

    private String id;
    private String nazev;
    private String popis;
    private ArrayList<String> idVychodu;
    private ArrayList<Lokace> vychody;
    private ArrayList<String> items;
    private ArrayList<Item> itemyVLokaci;

    public Lokace() {
        this.itemyVLokaci = new ArrayList<>();
        this.vychody = new ArrayList<>();
        this.idVychodu = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public Lokace(String id,ArrayList<String> idVychodu) {
        this.id = id;
        this.idVychodu = idVychodu;
        this.vychody = new ArrayList<>();
        this.itemyVLokaci = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public String getNazev(){
        return nazev;
    }

    public String getPopis(){
        return popis;
    }

    public ArrayList<Item> getItemyVLokaci(){
        return itemyVLokaci;
    }

    public ArrayList<String> getIdVychodu(){
        return idVychodu;
    }

    public ArrayList<Lokace> getVychody() {
        return vychody;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public Item odebratItem(Item item){
        return itemyVLokaci.getFirst();
    }

    public String getId(){
        return id;
    }

    /**
     * Metoda ktera naplni ArayList itemu v lokaci podle ArrayListu id itemu z JSON souboru
     * @param vsechnyItemy ArrayList vsechnych hernich itemu
     */
    public void setItemyVLokaci(ArrayList<Item> vsechnyItemy){
        for (String item : items){
            for (int j = 0; j < vsechnyItemy.size(); j++) {
                if (item.equals(vsechnyItemy.get(j).getId())){
                    itemyVLokaci.add(vsechnyItemy.get(j));
                }
            }
        }
    }

    /**
     * Metoda ktera nastavi pole vsech vychodu podle ArrayListu id lokaci z JSON souboru
     * @param vsechnyLokace ArrayList vsechnych hernich lokaci
     */
    public void setVychody(ArrayList<Lokace> vsechnyLokace){
        for (int i = 0; i < idVychodu.size(); i++) {
            for (int j = 0; j < vsechnyLokace.size(); j++) {
                if (idVychodu.get(i).equals(vsechnyLokace.get(j).getId())){
                    vychody.add(vsechnyLokace.get(j));
                }
            }
        }
    }


    @Override
    public String toString() {
        return getMinus() + "\nid: " + this.id + "\n" + "nazev mistnosti: " + this.nazev + "\n" + "popis: " + this.popis + "\n" + getMinus();
    }

    public String getMinus(){
        String text = "";
        for (int i = 0; i < this.popis.length() + 5; i++) {
            text += "-";
        }
        return text;
    }
}
