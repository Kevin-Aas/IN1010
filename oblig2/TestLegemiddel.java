public class TestLegemiddel {
    public static void main(String[] args) {
        // Lager ett objekt av hver av subklassene:
        Vanlig vanlig1 = new Vanlig("Feranomol", 49, 200);
        Narkotisk narkotisk1 = new Narkotisk("Mallonin", 359, 100, 10);
        Vanedannede vanedannede1 = new Vanedannede("Zamidium", 99, 300, 5);

        // Sjekker om hentPris() metoden funker [Test 1 - 3]:
        if (vanlig1.hentPris() == 49) {
            System.out.println("Test 1 - Korrekt");
        } else {
            System.out.println("Test 1 - Feil");
        }
        if (narkotisk1.hentPris() == 359) {
            System.out.println("Test 2 - Korrekt");
        } else {
            System.out.println("Test 2 - Feil");
        }
        if (vanedannede1.hentPris() == 99) {
            System.out.println("Test 3 - Korrekt");
        } else {
            System.out.println("Test 3 - Feil");
        }

        // Sjekker om id-en til hvert objekt er riktig [Test 4 - 6]:
        if (vanlig1.id == 0) {
            System.out.println("Test 4 - Korrekt");
        } else {
            System.out.println("Test 4 - Feil");
        }
        if (narkotisk1.id == 0) {
            System.out.println("Test 5 - Korrekt");
        } else {
            System.out.println("Test 5 - Feil");
        }
        if (vanedannede1.id == 0) {
            System.out.println("Test 6 - Korrekt");
        } else {
            System.out.println("Test 6 - Feil");
        }

        // Sjekker om settNyPris funker som den skal [Test 7 - 9]:
        vanlig1.settNyPris(59);
        narkotisk1.settNyPris(399);
        vanedannede1.settNyPris(149);
        if (vanlig1.hentPris() == 59) {
            System.out.println("Test 7 - Korrekt");
        } else {
            System.out.println("Test 7 - Feil");
        }
        if (narkotisk1.hentPris() == 399) {
            System.out.println("Test 8 - Korrekt");
        } else {
            System.out.println("Test 8 - Feil");
        }
        if (vanedannede1.hentPris() == 149) {
            System.out.println("Test 9 - Korrekt");
        } else {
            System.out.println("Test 9 - Feil");
        }

        // Tester om id-en er riktig naar man lager flere instanser av samme klasse:
        // [Test 10]
        Vanlig vanlig2 = new Vanlig("Trigamonol", 29, 150);
        if (vanlig2.id == 1) {
            System.out.println("Test 10 - Korrekt");
        } else {
            System.out.println("Feil");
        }
        
        System.out.println(vanlig2.toString());
        System.out.println(narkotisk1.toString());


    }
}
