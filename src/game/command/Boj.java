package game.command;

import game.dialog.Dialog;
import game.lokace.Lokace;
import game.postavy.Entita;

import java.util.ArrayList;

/**
 * Trida pro command Boj ktery umoznuje hraci bojovat s Goliasem
 */
public class Boj implements Command{

    private int cislo;
    private Entita hrac;
    private Entita protivnik;
    private ArrayList<Lokace> lokace;
    private Dialog dialog;
    private boolean ukonceno = false;

    public Boj(int cislo, Entita hrac, Entita protivnik, ArrayList<Lokace> lokace, Dialog dialog) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.protivnik = protivnik;
        this.lokace = lokace;
        this.dialog = dialog;
    }

    /**
     * Metoda pro command ktery bud dovoli hracovi zabit protivnika a nebo se vzdat a umrit
     * @param text nepouzivan
     * @return text ktery hrace utvrdi v tom ze budto umrel a nebo zabil protivnika
     */
    @Override
    public String execute(String text) {
        if (cislo == 1){
            if ((hrac.getInventar().stream().anyMatch(item -> item.getId().equals("pistole")) || hrac.getInventar().stream().anyMatch(item -> item.getId().equals("kamen")) )
                    && hrac.isKamera()){
                vyprazdnitInventarProtivnika();
                hrac.setPorazenyGolias(true);
                return dialog.getDialog(18, "") + "Porazil jsi: " + protivnik.getJmeno() + "\n" + dialog.getDialog(19, "");
            } else if ((hrac.getInventar().stream().anyMatch(item -> item.getId().equals("pistole")) || hrac.getInventar().stream().anyMatch(item -> item.getId().equals("kamen")) )
                    && !hrac.isKamera()) {
                return "Neni koho zabit";
            } else {
                hrac.setZivoty(0);
                ukonceno = true;
                return "nemas zadne zbrane, zabil te: " + protivnik.getJmeno();
            }
        } else {
            hrac.setZivoty(0);
            ukonceno = true;
            return "umrel jsi\nzabil te: " + protivnik.getJmeno();
        }
    }

    /**
     * Metoda na vyprazdeni inventare protivnika do lokace hrace
     */
    private void vyprazdnitInventarProtivnika(){
        for (int i = protivnik.getInventar().size() - 1; i >= 0; i--) {
            lokace.get(cisloLokace()).getItemyVLokaci().add(protivnik.getInventar().get(i));
            hrac.getAktualniLokace().getItemyVLokaci().add(protivnik.getInventar().get(i));
            protivnik.getInventar().remove(i);
        }
    }

    /**
     * Metoda ktera zjisti v jake lokaci se hrac nachazi
     * @return index lokace hrace
     */
    private int cisloLokace(){
        for (int i = 0; i < lokace.size(); i++) {
            if (lokace.get(i).getId().equals(hrac.getAktualniLokace().getId())){
                return i;
            }
        }
        return 0;
    }

    /**
     * Metoda ktera rika jestli command ukoncuje hru nebo ne
     * @return false protoze command neukoncuje hru
     */
    @Override
    public boolean exit() {
        return ukonceno;
    }
}