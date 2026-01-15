package game.itemy;

public class KarlovaPistole extends Item{

    private int poskozeni;

    public KarlovaPistole(String jmeno, String popis, int poskozeni) {
        super(jmeno, popis);
        this.poskozeni = poskozeni;
    }

    public String vystrelit(){
        return "Bum";
    }
}
