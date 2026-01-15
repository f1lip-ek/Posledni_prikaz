package game.postavy;

import game.itemy.Item;
import game.lokace.Lokace;

import java.util.ArrayList;

public class Hrac extends Entita {

    private ArrayList<Item> inventar;
    private final int MAX_NOSNOST = 2;

    public Hrac(String jmeno, Lokace aktualniLokace) {
        super(jmeno, aktualniLokace);
        this.inventar = new ArrayList<>(MAX_NOSNOST);
    }

    public boolean vlozDoInventare(Item vec) {
        return true;
    }

    public boolean vyhodZInventare(Item vec) {
        return true;
    }

    public boolean obsahujeVec(String nazevVeci) {
        return true;
    }
}
