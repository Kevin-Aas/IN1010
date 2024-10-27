class Hovedprogram {
    public static void main(String[] args){
        Brev brevet = new Brev("Kevin Aslesen", "Sylvia Olafsen");
        brevet.skrivLinje("Hvordan går det?");
        brevet.skrivLinje("Mye å lese for tiden?");
        brevet.lesBrev();
    }
}