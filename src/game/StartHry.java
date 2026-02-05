package game;

import game.dialog.Dialog;

public class StartHry {

    private Dialog dialog;

    public StartHry(Dialog dialog){
        this.dialog = dialog;
    }

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
