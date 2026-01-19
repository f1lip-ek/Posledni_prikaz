package game.command;

public class PouzijPredmet implements Command{

    private int cislo;

    public PouzijPredmet(int cislo) {
        this.cislo = cislo;
    }

    @Override
    public String execute() {
        if (cislo == 1){
            return "";
        }else {
            return "";
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}