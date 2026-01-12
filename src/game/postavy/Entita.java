package game.postavy;

import game.lokace.Lokace;

public abstract class Entita {

    protected String jmeno;
    protected Lokace lokace;

    public abstract void setLokace();

}
