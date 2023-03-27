public class Lege implements Comparable<Lege>{
    public final String navn;
    IndeksertListe<Resept> utskrevneResepter = new IndeksertListe<>();

    public Lege(String navn) {
        this.navn = navn;
    }

    public String hentNavn() {
        return navn;
    }

    // Hente reseptene legen har utskrevet:
    public IndeksertListe<Resept> hentUtskrevneResepter() {
        return utskrevneResepter;
    }

    // Skriver Hvit resept:
    public HvitResept skrivHvitResept(Legemiddel legemiddel, Pasient pasient, int reit) 
            throws UlovligUtskrift {
                testNarkotisk(legemiddel);
                HvitResept nyResept = new HvitResept(legemiddel, this, pasient, reit);
                pasient.leggTilResept(nyResept);
                utskrevneResepter.leggTil(nyResept);
                return nyResept;
    }
    // Skriver Militær resept:
    public MilResept skrivMilResept(Legemiddel legemiddel, Pasient pasient) 
            throws UlovligUtskrift {
                testNarkotisk(legemiddel);
                MilResept nyResept = new MilResept(legemiddel, this, pasient);
                pasient.leggTilResept(nyResept);
                utskrevneResepter.leggTil(nyResept);
                return nyResept;
    }
    // Skrvier P-resept:
    public PResept skrivPResept(Legemiddel legemiddel, Pasient pasient, int reit) 
            throws UlovligUtskrift {
                testNarkotisk(legemiddel);
                PResept nyResept = new PResept(legemiddel, this, pasient, reit);
                pasient.leggTilResept(nyResept);
                utskrevneResepter.leggTil(nyResept);
                return nyResept;
    }
    // Skriver Blaa resept:
    public BlaaResept skrivBlaaResept(Legemiddel legemiddel, Pasient pasient, int reit) 
            throws UlovligUtskrift {
                testNarkotiskSpesialist(legemiddel, this);
                BlaaResept nyResept = new BlaaResept(legemiddel, this, pasient, reit);
                pasient.leggTilResept(nyResept);
                utskrevneResepter.leggTil(nyResept);
                return nyResept;
    }

    public void testNarkotisk(Legemiddel lm) throws UlovligUtskrift{
        // Brukes for aa unngaa at narkotiske legemidler blir skrevet på noe annet
        // enn blaa resepet.
        if (lm instanceof Narkotisk) {
            throw new UlovligUtskrift(lm);
        }
    }

    public void testNarkotiskSpesialist(Legemiddel lm, Lege l) throws UlovligUtskrift{
        // Sjekker om legemiddelet er narkotisk og om legen ikke er en spesialist.
        if (lm instanceof Narkotisk && !(l instanceof Spesialist)) {
            // Kaster et exception hvis det er tilfellet.
            throw new UlovligUtskrift(l, lm);
        }
    }

    // For aa kunne sammenligne navnet til to leger:
    @Override
    public int compareTo(Lege nyLege) {
        String nyLegeNavn = nyLege.hentNavn();
        // Antar at legenavn er på formen "Dr. etternavn"
        char denneLegeFor = this.navn.charAt(4);
        char nyLegeFor = nyLegeNavn.charAt(4);
        if (denneLegeFor > nyLegeFor) {
            return 1;
        } else if (denneLegeFor < nyLegeFor) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return navn + "";              
    }
}
