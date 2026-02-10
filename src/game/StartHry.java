package game;

import game.dialog.Dialog;

/**
 * Trida s metodou ktera se spousti na zacatku hry a tak trochu uvede hrace do deje
 */
public class StartHry {

    private Dialog dialog;

    public StartHry(Dialog dialog){
        this.dialog = dialog;
    }

    /**
     * Vypise prvnich nekolik dialogu na startu hry
     */
    public void start(){
        try {
            for (int i = 0; i < 3; i++) {
                System.out.println(dialog.getDialog(i, ""));
                Thread.sleep(200);
            }
            Thread.sleep(2000);
            System.out.println(dialog.getDialog(3, ""));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        System.out.println(new Ukoly().execute(""));
    }

}
