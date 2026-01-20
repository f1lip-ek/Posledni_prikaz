package game.itemy;

public class Item {

    private String id;

    private String jmeno;
    private String popis;
    private int poskozeni;
    private boolean jeAktivni;
    private boolean obsahujeVirus;
    private String akce;

    public Item(String jmeno, String popis) {
        this.jmeno = jmeno;
        this.popis = popis;
    }

    public String getJmeno(){
        return jmeno;
    }

    public String getId(){
        return id;
    }

    public String getPopis() {
        return popis;
    }

    public int getPoskozeni() {
        return poskozeni;
    }

    public boolean isJeAktivni() {
        return jeAktivni;
    }

    public boolean isObsahujeVirus() {
        return obsahujeVirus;
    }

    public String getAkce() {
        return akce;
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
