package game.itemy;

public class USB extends Item {

    private boolean obsahujeVirus;

    public USB(String jmeno, String popis, boolean obsahujeVirus) {
        super(jmeno, popis);
        this.obsahujeVirus = obsahujeVirus;
    }

    public String nahratVirus(){
        return "Virus nahran.";
    }
}
