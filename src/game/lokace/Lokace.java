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
    private String[] idVychodu;
    private Lokace[] vychody;
    private ArrayList<String> items;
    private ArrayList<Item> itemyVLokaci;
    private boolean porazenyGolias;
    private boolean kontrolaServeru;

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

    public String[] getIdVychodu(){
        return idVychodu;
    }

    public Lokace[] getVychody() {
        return vychody;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public boolean isPorazenyGolias() {
        return porazenyGolias;
    }

    public boolean isKontrolaServeru() {
        return kontrolaServeru;
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
                "}";
    }
}
