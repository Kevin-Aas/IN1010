class UlovligUtskrift extends Exception {
    UlovligUtskrift (Lege l, Legemiddel lm) {
        super("ERROR: Legen "+l.hentNavn()+" har ikke lov til aa skrive ut "+lm.hentNavn());
    }
    UlovligUtskrift (Legemiddel lm) {
        super("ERROR: Kan kun skrive ut "+lm.hentNavn()+" (narkotisk) paa blaa resept.");
    }
}