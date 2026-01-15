package game.lokace;

public class Serverovna extends Lokace {

    private boolean kontrolaServeru = false;

    public Serverovna(String nazev, String popis) {
        super(nazev, popis);
    }

    public boolean getKontrolaServeru(){
        return kontrolaServeru;
    }
}