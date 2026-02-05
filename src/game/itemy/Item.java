package game.itemy;

/**
 * Trida ktera slouzi jako sablona ke vsem itemum
 */
public class Item {

    private String id;

    private String jmeno;
    private String popis;
    private int poskozeni;
    private boolean jeAktivni;
    private boolean obsahujeVirus;
    private boolean zkontrolovan;
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
        return "\nid: " + this.id + "\n" + "nazev: " + this.jmeno + "\n" + "popis: " + this.popis + "\n";
    }
}
