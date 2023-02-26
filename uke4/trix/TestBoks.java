public class TestBoks {
    public static void main(String[] args) {
        // Førte boks:
        Boks boks1 = new Boks(1, 1, 1);

        // Tester areal metode:
        int areal1 = boks1.beregnAreal();
        if (areal1 == (1*1*6)) {
            System.out.println("Riktig - 1");
        } else {
            System.out.println("Feil - 1");
        }

        // Tester volum metode:
        int volum1 = boks1.beregnVolum();
        if (volum1 == 1) {
            System.out.println("Riktig - 2");
        } else {
            System.out.println("Feil - 2");
        }

        // Andre boks:
        Boks boks2 = new Boks(2, 2, 2);

        // Tester areal metode:
        int areal2 = boks2.beregnAreal();
        if (areal2 == (2*2*6)) {
            System.out.println("Riktig - 3");
        } else {
            System.out.println("Feil - 3");
        }

        // Tester volum metode:
        int volum2 = boks2.beregnVolum();
        if (volum2 == (2*2*2)) {
            System.out.println("Riktig - 4");
        } else {
            System.out.println("Feil - 4");
        }
    }
}
