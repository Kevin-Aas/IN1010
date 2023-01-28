class Baathus {

    int antPlass;
    Baat[] baater;
    int lagtTil = 0;

    public Baathus (int antallPlasser) {
        antPlass = antallPlasser;
        baater = new Baat[antPlass];
    }

    public void settInn (Baat nyBaat) {

        if (baater[antPlass-1] != null) {
            System.out.println("ERROR: Er ikke plass til flere baater.");
        } else {
            for (int i=0; i<antPlass; i++) {
                if (baater[i] != null) {
                    continue;
                } else {
                    baater[i] = nyBaat;
                    System.out.println("Ny baat ble lagt til!");
                    break;
                }
            }
        }
    }

    public void skrivBaater() {
        for (int i=0; i<antPlass; i++) {
            Baat baat = baater[i];
            System.out.println(baat.hentInfo());
        }
    }
}