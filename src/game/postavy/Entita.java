package game.postavy;

import game.lokace.Lokace;

public abstract class Entita {

    protected String jmeno;
    protected Lokace aktualniLokace;
    protected int zivoty;

    public Entita(String jmeno, Lokace aktualniLokace) {
        this.jmeno = jmeno;
        this.aktualniLokace = aktualniLokace;
    }

    public String getJmeno(){
        return jmeno;
    }

    public void setLokace(Lokace kam){
        this.aktualniLokace = kam;
    }
}
