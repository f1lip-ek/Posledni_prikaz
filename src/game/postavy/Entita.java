package game.postavy;

import game.itemy.Item;
import game.lokace.Lokace;

import java.util.ArrayList;

public abstract class Entita {

    protected String id;

    protected String jmeno;
    protected Lokace aktualniLokace;
    protected int zivoty;
    protected boolean jeNepratelska;
    protected String[] dialogy;
    protected ArrayList<Item> inventar;
    protected int MAX_NOSNOST;

    public Entita(String jmeno, Lokace aktualniLokace, boolean jeNepratelska) {
        this.jmeno = jmeno;
        this.aktualniLokace = aktualniLokace;
        this.jeNepratelska = jeNepratelska;
    }

    public String getJmeno(){
        return jmeno;
    }

    public void setLokace(Lokace kam){
        this.aktualniLokace = kam;
    }
}
