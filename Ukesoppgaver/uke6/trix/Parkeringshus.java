public class Parkeringshus {
    static Parkeringsplass[] etasje1 = new Parkeringsplass[10];
    static Parkeringsplass[] etasje2 = new Parkeringsplass[10];

    public static void main(String[] args) {
        // Oppretter biler og motorsykler:
        Bil audi = new Bil("AB12345", 4);
        Bil bmw  = new Bil("BA54321", 5);
        Bil opel = new Bil("AS95746", 3);
        Motorsykkel crosser = new Motorsykkel("AH46253", 3);
        Motorsykkel cruiser = new Motorsykkel("BJ83774", 5);
        Motorsykkel lwRider = new Motorsykkel("KD81774", 4);

        // Lager parkeringsplasser i de to etasjene (fire i forste og to i andre):
        etasje1[0] = new Parkeringsplass<Bil>();
        etasje1[1] = new Parkeringsplass<Motorsykkel>();
        etasje1[2] = new Parkeringsplass<Motorsykkel>();
        etasje1[3] = new Parkeringsplass<Bil>();
        etasje2[0] = new Parkeringsplass<Bil>();
        etasje2[1] = new Parkeringsplass<Motorsykkel>();

        // Parkerer biler og motorsykler pa plassene:
        etasje1[0].parker(audi);
        etasje1[1].parker(crosser);
        etasje1[2].parker(cruiser);
        etasje1[3].parker(bmw);
        etasje2[0].parker(opel);
        etasje2[1].parker(lwRider);

        // Motorsyklene kjører ut:
        etasje1[1].kjorUt();
        etasje1[1] = null;
        etasje1[2].kjorUt();
        etasje1[2] = null;
        etasje2[1].kjorUt();
        etasje2[1] = null;

    }
}
