public class TestOrdbeholder {
    public static void main(String[] args) {
        // Test nr 1 (Sjekk at pop på en tom liste returnerer korrekt):
        Ordbeholder ob1 = new Ordbeholder();
        if (ob1.pop() == null){
            System.out.println("Riktig - nr. 1");
        } else {
            System.out.println("Feil - nr. 1");
        }

        // Test nr 2 (Sjekk at settInn returnerer riktig med et nytt ord):
        Ordbeholder ob2 = new Ordbeholder();
        if (ob2.settInn("Hei")) {
            System.out.println("Riktig - nr. 2");
        } else {
            System.out.println("Feil - nr. 2");
        }

        // Test nr 3 (Sjekk at settInn returnerer riktig
        // når man setter inn et ord som allerede er i beholderen):
        Ordbeholder ob3 = new Ordbeholder();
        ob3.settInn("Okey");
        if (!ob3.settInn("Okey")) {
            System.out.println("Riktig - nr. 3");
        } else {
            System.out.println("Feil - nr. 3");
        }

        // Test nr 4 (Sett inn noen flere ord, og sjekk at antallOrd returnerer korrekt):
        Ordbeholder ob4 = new Ordbeholder();
        ob4.settInn("Sjokolade");
        ob4.settInn("Ost");
        ob4.settInn("Melk");
        if (ob4.antallOrd() == 3) {
            System.out.println("Riktig - nr. 4");
        } else {
            System.out.println("Feil - nr. 4");
        }

        // Test nr 5 (Sjekk at pop returnerer det siste elementet som ble lagt inn i listen):
        if (ob4.pop().equals("Melk")) {
            System.out.println("Riktig - nr. 5");
        } else {
            System.out.println("Feil - nr. 5");
        }

    }
}
