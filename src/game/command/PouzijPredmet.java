package game.command;

import game.postavy.Entita;

public class PouzijPredmet implements Command{

    private int cislo;
    private Entita hrac;

    public PouzijPredmet(int cislo, Entita hrac) {
        this.cislo = cislo;
        this.hrac = hrac;
    }

    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "pouzij predmet";
        }else {
            return "vypsani inventare";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}