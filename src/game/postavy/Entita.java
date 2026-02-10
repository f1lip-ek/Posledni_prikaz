package game.postavy;

import game.itemy.Item;
import game.lokace.Lokace;

import java.util.ArrayList;

/**
 * Trida ktera slouzi jako sablona ke vsem postavam
 */
public class Entita {

    private String id;

    private String jmeno;
    private String idAktualniLokace;
    private Lokace aktualniLokace;
    private int zivoty;
    private boolean jeNepratelska;
    private ArrayList<String> idItemu;
    private boolean porazenyGolias;
    private boolean kontrolaServeru;
    private boolean vymazaneChyby;
    private boolean rozhodnutiEl;
    private boolean kamera = false;
    private ArrayList<Item> inventar;
    private int cisloUkolu;
    private int MAX_NOSNOST;
    private int volba;

    public Entita() {}

    public Entita(String id){
        this.idItemu = new ArrayList<>();
        this.inventar = new ArrayList<>();
        this.MAX_NOSNOST = 2;
    }

    public String getJmeno(){
        return jmeno;
    }

    public String getId() {
        return id;
    }

    public String getIdAktualniLokace() {
        return idAktualniLokace;
    }

    public void setIdLokace(String idAktualniLokace){
        this.idAktualniLokace = idAktualniLokace;
    }

    public Lokace getAktualniLokace() {
        return aktualniLokace;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty += zivoty;
    }

    public boolean isJeNepratelska() {
        return jeNepratelska;
    }

    public ArrayList<String> getIdItemu() {
        return idItemu;
    }

    public ArrayList<Item> getInventar() {
        return inventar;
    }

    public int getMAX_NOSNOST() {
        return MAX_NOSNOST;
    }

    public boolean isPorazenyGolias() {
        return porazenyGolias;
    }

    public boolean isKontrolaServeru() {
        return kontrolaServeru;
    }

    public boolean isVymazaneChyby() {
        return vymazaneChyby;
    }

    public boolean isRozhodnutiEl() {
        return rozhodnutiEl;
    }

    public boolean isKamera() {
        return kamera;
    }

    public int getVolba() {
        return volba;
    }

    public int getCisloUkolu() {
        return cisloUkolu;
    }

    public void setPorazenyGolias(boolean porazenyGolias) {
        this.porazenyGolias = porazenyGolias;
    }

    public void setKontrolaServeru(boolean kontrolaServeru) {
        this.kontrolaServeru = kontrolaServeru;
    }

    public void setVymazaneChyby(boolean vymazaneChyby) {
        this.vymazaneChyby = vymazaneChyby;
    }

    public void setRozhodnutiEl(boolean rozhodnuti) {
        this.rozhodnutiEl = rozhodnuti;
    }

    public void setKamera(boolean kamera) {
        this.kamera = kamera;
    }

    public void setVolba(int volba) {
        this.volba = volba;
    }

    public void zvecitCisloUkolu() {
        this.cisloUkolu++;
    }

    /**
     * Metoda ktera naplni inventar hrace podle ArrayListu id itemu z JSON souboru
     * @param vsechnyItemy ArrayList vsechnych hernich itemu
     */
    public void setInventar(ArrayList<Item> vsechnyItemy){
        this.inventar = new ArrayList<>();
        for (int i = 0; i < idItemu.size(); i++) {
            for (int j = 0; j < vsechnyItemy.size(); j++) {
                if (idItemu.get(i).equals(vsechnyItemy.get(j).getId())){
                    this.inventar.add(vsechnyItemy.get(j));
                }
            }
        }
    }

    /**
     * Metoda ktera nastavi aktualni lokaci postavy podle id lokace z JSON souboru
     * @param vsechnyLokace ArrayList vsechnych hernich lokaci
     */
    public void setIdAktualniLokace(ArrayList<Lokace> vsechnyLokace){
        for (int i = 0; i < vsechnyLokace.size(); i++) {
            if (idAktualniLokace.equals(vsechnyLokace.get(i).getId())){
                this.aktualniLokace = vsechnyLokace.get(i);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Entita{" +
                "id='" + id + '\'' +
                ", jmeno='" + jmeno + '\'' +
                ", idAktualniLokace='" + idAktualniLokace + '\'' +
                ", zivoty=" + zivoty +
                ", jeNepratelska=" + jeNepratelska +
                ", idItemu=" + idItemu +
                ", inventar=" + inventar +
                ", MAX_NOSNOST=" + MAX_NOSNOST +
                '}';
    }
}
