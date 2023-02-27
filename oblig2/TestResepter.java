public class TestResepter {
    public static int test = 1;

    public static void main(String[] args) {
        // Lager noen leger og legemidler:
        Lege lege1 = new Lege("Kjetil Haraldson");
        Lege lege2 = new Lege("Per Sivertsen");
        Vanlig vanlig1 = new Vanlig("Feranomol", 49, 200);
        Narkotisk narkotisk1 = new Narkotisk("Mallonin", 359, 100, 10);
        Vanedannede vanedannede1 = new Vanedannede("Zamidium", 99, 300, 5);

        // Lager saa noen resepter:
        HvitResept resept1 = new HvitResept(vanlig1, lege1, 12, 5);
        MilResept resept2 = new MilResept(narkotisk1, lege1, 13);
        PResept resept3 = new PResept(vanlig1, lege2, 17, 20);
        BlaaResept resept4 = new BlaaResept(vanedannede1, lege1, 18, 10);

        // Tester hente metode [Test 1 - 6]:
        testInt(resept1.hentId(), 0);   // 1
        testInt(resept2.hentId(), 1);   // 2
        testLegemiddel(resept1.hentLegemiddel(), vanlig1);  // 3
        testLege(resept1.hentLege(), lege1);    // 4
        testInt(resept1.hentPasientId(), 12);   // 5
        testInt(resept1.hentReit(), 5);     // 6

        // Tester bruk metoden [Test 7 og 8]:
        testBruk(resept1);
        testBruk(resept2);

        // Tester farge metodene [Test 9 og 10]:
        testFarge(resept1, "hvit");
        testFarge(resept4, "blaa");

        // Tester prisene [11, 12, 13 og 14]:
        testInt(resept1.prisAaBetale(), 49);
        testInt(resept2.prisAaBetale(), 0);
        testInt(resept3.prisAaBetale(), 0);
        testInt(resept4.prisAaBetale(), 25); // Siden 99*0.25=24.75 avrundes til 25.
    }

    public static void testInt(int tall1, int tall2) {
        if (tall1 == tall2) {
            System.out.println("Test " + test + " - Korrekt");
        } else {
            System.out.println("Test " + test + " - Feil");
        }
        test++;
    }

    public static void testLegemiddel(Legemiddel legemdl1, Legemiddel legemdl2) {
        if (legemdl1 == legemdl2) {
            System.out.println("Test " + test + " - Korrekt");
        } else {
            System.out.println("Test " + test + " - Feil");
        }
        test++;
    }

    public static void testLege(Lege lege1, Lege lege2) {
        if (lege1 == lege2) {
            System.out.println("Test " + test + " - Korrekt");
        } else {
            System.out.println("Test " + test + " - Feil");
        }
        test++;
    }

    public static void testBruk(Resept resept) {
        if (resept.bruk()) {
            System.out.println("Test " + test + " - Korrekt");
        } else {
            System.out.println("Test " + test + " - Feil");
        }
        test++;
    }

    public static void testFarge(Resept resept, String farge) {
        if (resept.farge().equals(farge)) {
            System.out.println("Test " + test + " - Korrekt");
        } else {
            System.out.println("Test " + test + " - Feil");
        }
        test++;
    }
}
