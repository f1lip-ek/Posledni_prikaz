package game.lokace;

public class OpustenaUlice extends Lokace {

    private boolean porazenyGolias;

    public OpustenaUlice(String nazev, String popis, boolean porazenyGolias) {
        super(nazev, popis);
        this.porazenyGolias = porazenyGolias;

    }

    public boolean isPorazenyGolias(){
        return porazenyGolias;
    }
}