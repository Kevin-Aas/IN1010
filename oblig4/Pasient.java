public class Pasient {
    private static int antPasienter;
    public final String navn;
    public final String fodselsnr;
    public final int pasientId;
    public IndeksertListe<Resept> pasientResepter;

    public Pasient(String navn, String fodselsnr) {
        this.navn = navn;
        this.fodselsnr = fodselsnr;
        pasientId = antPasienter;
        antPasienter++;
        pasientResepter = new IndeksertListe<>();
    }

    public void leggTilResept(Resept nyResept) {
        pasientResepter.leggTil(nyResept);
    }

    public IndeksertListe<Resept> hentResepter() {
        return pasientResepter;
    }

    public String hentNavn() {
        return navn;
    }

    public String hentFodselsnr() {
        return fodselsnr;
    }

    public int hentPasientId() {
        return pasientId;
    }
}
