package game.command;

import game.lokace.Lokace;
import game.postavy.Entita;

import java.util.ArrayList;
import java.util.Arrays;

public class Pohyb implements Command{

    private int cislo;
    private Entita hrac;

    public Pohyb(int cislo, Entita hrac) {
        this.cislo = cislo;
        this.hrac = hrac;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "Muzes jit na: " + Arrays.toString(hrac.getAktualniLokace().getIdVychodu());
        }else {
            hrac.setIdLokace(text);
            return "Lokace zmenena na: " + text;
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}