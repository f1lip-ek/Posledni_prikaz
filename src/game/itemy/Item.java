package game.itemy;

public class Item {

    private String id;

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

    public String getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id='" + id + '\'' +
                ", jmeno='" + jmeno + '\'' +
                ", popis='" + popis + '\'' +
                ", poskozeni=" + poskozeni +
                ", jeAktivni=" + jeAktivni +
                ", obsahujeVirus=" + obsahujeVirus +
                ", akce='" + akce + '\'' +
                '}';
    }
}
