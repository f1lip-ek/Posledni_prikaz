package game.command;

import game.postavy.Entita;

public class VezmiPredmet implements Command{

    private int cislo;
    private Entita hrac;

    public VezmiPredmet(int cislo, Entita hrac) {
        this.cislo = cislo;
        this.hrac = hrac;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "ziskat predmet: " + text;
        }else {
            return "prohledani okoli";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}