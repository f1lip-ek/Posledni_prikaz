package game.itemy;

public class SledovaciZarizeni extends Item {

    private boolean jeAktivni;

    public SledovaciZarizeni(String jmeno, String popis, boolean jeAktivni) {
        super(jmeno, popis);
        this.jeAktivni = jeAktivni;
    }

    public String namontovat(){
        return "";
    }
}
