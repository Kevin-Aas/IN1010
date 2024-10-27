import java.util.ArrayList;

class Brev {
    String avsender;
    String mottaker;
    ArrayList<String> linjer = new ArrayList<String>();
    
    public Brev(String avsender, String mottaker){
        // Konstruktøren setter avsender og mottaker
        this.avsender = avsender;
        this.mottaker = mottaker;
    }

    public void skrivLinje(String linje){
        // Metoden legger til en tekstlinje i listen
        linjer.add(linje);
    }

    public void lesBrev(){
        // Metoden leser opp brevet linje for linje
        System.out.println("Hei, " + mottaker);
        System.out.println();
        for (String linje : linjer){
            System.out.println(linje);
        }
        System.out.println();
        System.out.println("Hilsen fra,");
        System.out.println(avsender);
    }
}