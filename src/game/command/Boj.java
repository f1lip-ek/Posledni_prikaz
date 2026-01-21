package game.command;

import game.postavy.Entita;

public class Boj implements Command{

    private int cislo;
    private Entita hrac;

    public Boj(int cislo, Entita hrac) {
        this.cislo = cislo;
        this.hrac = hrac;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "zautoc";
        }else {
            return "vzdej se (zabije te)";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}