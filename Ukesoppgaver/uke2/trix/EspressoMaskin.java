class EspressoMaskin {
    private int maxVannmengde = 1000; // Maksinen startes som full (1000ml).
    private int vannmengde = 0;

    // Lag espresso dersom det er nok vann
    public void lagEspresso() {
        // én espresso krever 40ml vann.
        if (vannmengde >= 40){
            System.out.println("Én espresso ble laget.");
            vannmengde -= 40;
        } else {
            System.out.println("Det er ikke nok vann til en espresso.");
            System.out.println("Du mangler " + (40 - vannmengde) + "ml.");
        }
       }

    // Lag lungo dersom det er nok vann
    public void lagLungo() {
        // én lungo krever 110ml vann.
        if (vannmengde >= 110){
            System.out.println("Én lungo ble laget.");
            vannmengde -= 110;
        } else {
            System.out.println("Det er ikke nok vann til en lungo.");
            System.out.println("Du mangler " + (110 - vannmengde) + "ml.");
        }
       }

    // Fyll på et gitt antall milliliter vann, dersom det er plass
    public void fyllVann(int ml) {
        if (vannmengde == maxVannmengde){
            System.out.println("Maskinen er allerde full.");
        } else if ((vannmengde+ml) > maxVannmengde){
            System.out.println("WoW! Det var litt mye vell?");
            System.out.println("Vennligst prøv å fyll på litt mindre.");
        } else {
            vannmengde += ml;
            System.out.println("Maskinen ble fylt opp til " + vannmengde + "ml.");            
        }
       }

    // Les av målestrekene på vanntanken og tilgjengelig vann i ml
    public int hentVannmengde() {
        return vannmengde;
       }
}