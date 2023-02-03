class Celle {
    boolean levende;
    Celle[] naboer;
    int antNaboer;
    int antLevendeNaboer;

    public Celle(){
        levende = false;
        naboer = new Celle[8];  
        antNaboer = 0;
        antLevendeNaboer = 0;      
    }

    public void settLevende(){
        levende = true;
    }

    public void settDoed(){
        levende = false;
    }

    public boolean erLevende(){
        if (levende){
            return true;
        } else{
            return false;
        }
    }

    public char hentStatusTegn(){
        if (levende){
            return 'O';
        } else{
            return '.';
        }
    }

    public void leggTilNabo(Celle nabo){
        for (int i=0; i<naboer.length;i++){
            if (naboer[i] == null){
                naboer[i] = nabo;
                break;
            }
        }
        antNaboer++;
    }

    public void tellLevendeNaboer(){
        antLevendeNaboer = 0;
        for (Celle c : naboer){
            if (c != null && c.levende){
                antLevendeNaboer++;
            }
        }
    }

    public void oppdaterStatus(){
        if (levende){
            if (antLevendeNaboer < 2 || antLevendeNaboer > 3){
                levende = false;
            }
        } else{
            if (antLevendeNaboer == 3){
                levende = true;
            }
        }
    }

}