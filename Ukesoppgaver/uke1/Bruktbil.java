public class Bruktbil {
    public static void main(String[] args){

        Teller Audi = new Teller();
        Teller BMW = new Teller();

        Audi.leggTil();
        Audi.leggTil();
        BMW.leggTil();

        System.out.println("Antall interesserte i Audi: " + Audi.visAntall());
        System.out.println("Antall interesserte i BMW: " + BMW.visAntall());
    }
}

class Teller {
    private int antall;

    public void leggTil(){
        antall = antall + 1;
    }

    public int visAntall(){
        return antall;
    }
}
