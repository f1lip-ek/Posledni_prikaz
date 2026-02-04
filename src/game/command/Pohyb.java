package game.command;

import game.lokace.Lokace;
import game.postavy.Entita;

import java.util.ArrayList;

/**
 * Trida pro command ktery meni lokaci hrace a pro command ktery zobrazuje kam hrac muze jit z aktualni lokace
 */
public class Pohyb implements Command{

    private final int cislo;
    private final Entita hrac;
    private final ArrayList<Lokace> vsechnyLokace;

    public Pohyb(int cislo, Entita hrac, ArrayList<Lokace> vsechnyLokace) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.vsechnyLokace = vsechnyLokace;
    }

    /**
     * Metoda ktera overi jestli ta mistnost kam chce hrac jit existuje
     * @param text id mistnosti kam chce hrac jit
     * @return 2 pokud mistnost existuje a muze tam jit hrac ze sve aktualni mistnosti, 1 pokud mistnost existuje ale hrac tam ze sve mistnosti jit nemuze, 0 pokud mistnost neexistuje
     */
    private int obsahuje(String text){
        for (int i = 0; i < vsechnyLokace.size(); i++) {
            if (vsechnyLokace.get(i).getId().equals(text) && hrac.getAktualniLokace().getIdVychodu().contains(text)){
                return 2;
            } else if (vsechnyLokace.get(i).getId().equals(text) && !hrac.getAktualniLokace().getIdVychodu().contains(text)) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Metoda pro command ktery meni lokaci hrace a take zobrazuje kam hrac muze jit
     * @param text urcuje misto kam se ma hrac presunout
     * @return text ktery hrace presvedci o tom ze se opravdu zmenila lokace
     */
    @Override
    public String execute(String text) {
        if (cislo == 1){
            return "Muzes jit na: " + hrac.getAktualniLokace().getIdVychodu();
        }else {
            if (obsahuje(text) == 2){
                hrac.setIdLokace(text);
                hrac.setIdAktualniLokace(vsechnyLokace);
                return "Lokace zmenena na: " + text + "\n" +  hrac.getAktualniLokace().getPopis();
            } else if (obsahuje(text) == 1) {
                return "Do teto mistnosti nemuzes jit z tve aktualni mistonsti";
            } else {
                return "Nemuzes tam jit protoze to neexistuje";
            }
        }
    }

    /**
     * Metoda ktera rika jestli command ukoncuje hru nebo ne
     * @return false protoze command neukoncuje hru
     */
    @Override
    public boolean exit() {
        return false;
    }
}