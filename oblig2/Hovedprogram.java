public class Hovedprogram {
    public static void main(String[] args) {
        // En instans av hver klasse:
        Lege lege1 = new Lege("Kjetil Haraldson");
        Spesialist lege2 = new Spesialist("Gunnar Robertsen", "548762");
        Vanlig vanlig1 = new Vanlig("Feranomol", 49, 200);
        Narkotisk narkotisk1 = new Narkotisk("Mallonin", 359, 100, 10);
        Vanedannede vanedannede1 = new Vanedannede("Zamidium", 99, 300, 5);
        HvitResept resept1 = new HvitResept(vanlig1, lege1, 12, 5);
        MilResept resept2 = new MilResept(narkotisk1, lege2, 13);
        PResept resept3 = new PResept(vanlig1, lege1, 17, 20);
        BlaaResept resept4 = new BlaaResept(vanedannede1, lege1, 18, 10);

        // Printer ut informasjon om objektene:
        System.out.println();
        System.out.println("**Informasjon om legene**:");
        System.out.println("" + lege1);
        System.out.println("" + lege2);
        System.out.println();
        System.out.println("**Informasjon om legemidlene**:");
        System.out.println("" + vanlig1);
        System.out.println("" + narkotisk1);
        System.out.println("" + vanedannede1);
        System.out.println();
        System.out.println("**Informasjon om reseptene**:");
        System.out.println("" + resept1);
        System.out.println("" + resept2);
        System.out.println("" + resept3);
        System.out.println("" + resept4);
    }
}
