package game.command;

public class PouzijPredmet implements Command{

    private int cislo;

    public PouzijPredmet(int cislo) {
        this.cislo = cislo;
    }

    @Override
    public String execute(Object object) {
        if (cislo == 1){
            return "pouzij predmet";
        }else {
            return "vypsani inventare";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}