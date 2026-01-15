package game.itemy;

public abstract class Item {

    protected String jmeno;
    protected String popis;

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
