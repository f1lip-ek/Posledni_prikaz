package game.postavy;

import game.lokace.Lokace;

public class AI extends Entita {

    private boolean jeNepratelska;

    public AI(String jmeno, Lokace aktualniLokace, boolean jeNepratelska) {
        super(jmeno, aktualniLokace, jeNepratelska);
    }

    public void interakceSystemu(){

    }
}
