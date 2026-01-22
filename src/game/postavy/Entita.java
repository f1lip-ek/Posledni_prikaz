package game.postavy;

import game.itemy.Item;
import game.lokace.Lokace;

import java.util.ArrayList;
import java.util.Arrays;

public class Entita {

    private String id;

    private String jmeno;
    private String idAktualniLokace;
    private Lokace aktualniLokace;
    private int zivoty;
    private boolean jeNepratelska;
    private String[] dialogy;
    private ArrayList<String> idItemu;
    private ArrayList<Item> inventar;
    private int MAX_NOSNOST;

    public Entita() {}

    public String getJmeno(){
        return jmeno;
    }

    public String getId() {
        return id;
    }

    public String getIdAktualniLokace() {
        return idAktualniLokace;
    }

    public void setIdLokace(String idAktualniLokace){
        this.idAktualniLokace = idAktualniLokace;
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    public int getZivoty() {
        return zivoty;
    }

    public boolean isJeNepratelska() {
        return jeNepratelska;
    }

    public String[] getDialogy() {
        return dialogy;
    }

    public ArrayList<String> getIdItemu() {
        return idItemu;
    }

    public ArrayList<Item> getInventar() {
        return inventar;
    }

    public int getMAX_NOSNOST() {
        return MAX_NOSNOST;
    }

    public void setInventar(ArrayList<Item> vsechnyItemy){
        for (int i = 0; i < idItemu.size(); i++) {
            for (int j = 0; j < vsechnyItemy.size(); j++) {
                if (idItemu.get(i).equals(vsechnyItemy.get(j).getId())){
                    inventar.add(vsechnyItemy.get(j));
                }
            }
        }
    }

    public void setIdAktualniLokace(ArrayList<Lokace> vsechnyLokace){
        for (int i = 0; i < vsechnyLokace.size(); i++) {
            if (idAktualniLokace.equals(vsechnyLokace.get(i).getId())){
                this.aktualniLokace = vsechnyLokace.get(i);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Entita{" +
                "id='" + id + '\'' +
                ", jmeno='" + jmeno + '\'' +
                ", idAktualniLokace='" + idAktualniLokace + '\'' +
                ", zivoty=" + zivoty +
                ", jeNepratelska=" + jeNepratelska +
                ", dialogy=" + Arrays.toString(dialogy) +
                ", idItemu=" + idItemu +
                ", inventar=" + inventar +
                ", MAX_NOSNOST=" + MAX_NOSNOST +
                '}';
    }
}
