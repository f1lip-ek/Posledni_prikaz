package game.itemy;

public abstract class Item {

    protected String id;

    protected String jmeno;
    protected String popis;
    protected int poskozeni;
    protected boolean jeAktivni;
    protected boolean obsahujeVirus;
    protected String akce;

    public Item(String jmeno, String popis) {
        this.jmeno = jmeno;
        this.popis = popis;
    }

    public String getJmeno(){
        return jmeno;
    }

    public String pouzit(){
        return popis;
    }

}
