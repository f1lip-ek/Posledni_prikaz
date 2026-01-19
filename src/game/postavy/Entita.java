package game.postavy;

import game.itemy.Item;
import game.lokace.Lokace;

import java.util.ArrayList;

public class Entita {

    protected String id;

    protected String jmeno;
    protected String idAktualniLokace;
    protected Lokace aktualniLokace;
    protected int zivoty;
    protected boolean jeNepratelska;
    protected String[] dialogy;
    protected ArrayList<String> idItemu;
    protected ArrayList<Item> inventar;
    protected int MAX_NOSNOST;

    public Entita() {}

    public String getJmeno(){
        return jmeno;
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
                break;
            }
        }
    }
}
