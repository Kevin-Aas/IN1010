public class Kontroll {
    GUI gui;
    Modell modell;
    int rader;
    int kolonner;
    Thread traad;

    public Kontroll(int rader, int kolonner) {
        this.rader = rader;
        this.kolonner = kolonner;
    }

    public void kjor() {
        gui = new GUI(this, rader, kolonner);
        modell = new Modell(rader, kolonner);
    }

    public void start() {
        traad = new Thread(new HentOgLesRunnable(gui, modell));
        traad.start();
    }

    public void avslutt() {
        System.exit(0);
    }
}

class HentOgLesRunnable implements Runnable {
    GUI gui;
    Modell modell;
    HentOgLesRunnable(GUI gui, Modell modell) {
        this.gui = gui;
        this.modell = modell;
    }
    @Override
    public void run() {
        // Modellen leser rutenettet fra GUIet (1)
        // og GUIet oppdatere rutenett gitt den oppdaterte versjonen fra modellen (2)
        while (true) {
            try {
                modell.lesGUIRutenett(gui.hentRutenett());  // (1)
                gui.oppdaterRutenett(modell.hentModellRutenett());  // (2)
                Thread.sleep(2000); // sover i 2 sekunder
            } catch (Exception e) {
                System.out.println("Noe gikk galt med traaden!");
                System.exit(1);
            }
        }
    }
}