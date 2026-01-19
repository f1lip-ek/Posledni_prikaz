package game.postavy;

import game.lokace.Lokace;

public class NPC extends Entita {

    private String dialog;

    public NPC(String jmeno, Lokace aktualniLokace) {
        super(jmeno, aktualniLokace, false);
    }

    public String mluvit(){
        return dialog;
    }
}
