package game.itemy;

import java.io.Serializable;

/**
 * Trida ktera slouzi jako sablona ke vsem itemum
 */
public class Item implements Serializable {

    private String id;

    private String jmeno;
    private String popis;
    private int poskozeni;
    private boolean jeAktivni;
    private boolean obsahujeVirus;
    private boolean zkontrolovan;
    private String akce;

    public Item(String id, String jmeno) {
        this.id = id;
        this.jmeno = jmeno;
    }

    public Item(){}

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

    public void setId(String id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "\nid: " + this.id + "\n" + "nazev: " + this.jmeno + "\n" + "popis: " + this.popis + "\n";
    }
}
