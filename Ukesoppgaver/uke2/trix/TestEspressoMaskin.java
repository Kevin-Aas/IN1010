public class TestEspressoMaskin {
    public static void main(String[] args) {
    //Antar at maskinen er tom ved opprettelse.
    EspressoMaskin maskin = new EspressoMaskin();

    maskin.fyllVann(500);
    maskin.lagEspresso();
    maskin.lagLungo();
    maskin.lagEspresso();
    }
}