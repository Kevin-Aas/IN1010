class Verden {
    Rutenett rutenett;
    int genNr;

    public Verden(int rad, int kol){
        rutenett = new Rutenett(rad, kol);
        genNr = 0;
        rutenett.fyllMedTilfeldigeCeller();
        rutenett.kobleAlleCeller();
    }

    public void tegn(){
        System.out.println("-------------");
        System.out.println("Generasjon #" + genNr);
        rutenett.tegnRutenett();
        System.out.println("Antall levende celler: " + rutenett.antallLevende());
        System.out.println("------------------------");
        System.out.println();
    }

    public void oppdatering(){
        for (int i=0; i<rutenett.antRader; i++){
            for (int j=0; j<rutenett.antKolonner; j++){
                rutenett.hentCelle(i, j).tellLevendeNaboer();
            }
        }
        for (int i=0; i<rutenett.antRader; i++){
            for (int j=0; j<rutenett.antKolonner; j++){
                rutenett.hentCelle(i, j).oppdaterStatus();
            }
        }
        genNr++;
    }

}