class Rutenett {
    int antRader;
    int antKolonner;
    Celle[][] rutene;
    
    public Rutenett(int rad, int kol) {
        antRader = rad;
        antKolonner = kol;
        rutene = new Celle[rad][kol];
    }

    public void lagCelle(int rad, int kol){
        Celle celle = new Celle();
        if (Math.random() <= 0.3333){
            celle.settLevende();
        }
        rutene[rad][kol] = celle;
    }

    public void fyllMedTilfeldigeCeller(){
        for (int i=0; i<antRader; i++){
            for (int j=0; j<antKolonner; j++){
                lagCelle(i, j);
            }
        }
    }

    public Celle hentCelle(int rad, int kol){
        if (rad < 0 || rad > antRader-1 || kol < 0 || kol > antKolonner-1){
            return null;
        } else{
            return rutene[rad][kol];
        }
    }

    private void linje(int kol){
        System.out.print("+");
        for (int j=0; j<kol; j++){
            System.out.print("---+");
        }
        System.out.println();
    }

    public void tegnRutenett(){
        System.out.println();
        for (int i=0; i<antRader; i++){
            linje(antKolonner);
            System.out.print("|");
            for (int j=0; j<antKolonner; j++){
                System.out.print(" "+rutene[i][j].hentStatusTegn()+" |");
            }
            System.out.println();
        }
        linje(antKolonner);
        System.out.println();
    }

    public void settNaboer(int rad, int kol){
        Celle oppH = hentCelle(rad+1, kol+1);    // opp, høyre
        Celle midtH = hentCelle(rad+1, kol);      // midt, høyre
        Celle nedeH = hentCelle(rad+1, kol-1);    // nede, høyre    
        Celle nedeM = hentCelle(rad, kol-1);      // nede, midt
        Celle nedeV = hentCelle(rad-1, kol-1);    // nede, venstre
        Celle midtV = hentCelle(rad-1, kol);      // midt, venstre    
        Celle oppV = hentCelle(rad-1, kol+1);    // opp, venstre
        Celle oppM = hentCelle(rad, kol+1);      // opp, midt
        Celle[] naboCeller = {oppH, midtH, nedeH, nedeM, nedeV, midtV, oppV, oppM};

        for (Celle nabo : naboCeller){
            if (nabo != null){
                hentCelle(rad, kol).leggTilNabo(nabo);
            }
        }
    }

    public void kobleAlleCeller(){
        
    }
}