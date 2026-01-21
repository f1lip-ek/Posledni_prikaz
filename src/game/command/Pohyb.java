package game.command;

import game.lokace.Lokace;
import game.postavy.Entita;

import java.util.ArrayList;

public class Pohyb implements Command{

    private int cislo;
    private Entita hrac;
    private ArrayList<Lokace> lokace;

    public Pohyb(int cislo, Entita hrac, ArrayList<Lokace> lokace) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.lokace = lokace;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "vypsani vychodu";
        }else {
            return "zmena mista";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}