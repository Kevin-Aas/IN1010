public class TestFigurer {

    public static void main(String[] args) {
        
        Rektangel figur1 = new Rektangel(3, 5);
        Sirkel figur2 = new Sirkel(1);

        // Test 1:
        if (figur1.beregnAreal() == 15) {
            System.out.println("Test 1 - OK");
        } else {
            System.out.println("Test 1 - Feil");
        }

        // Test 2:
        if (figur1.beregnOmkrets() == 16) {
            System.out.println("Test 2 - OK");
        } else {
            System.out.println("Test 2 - Feil");
        }

        // Test 3:
        if (figur2.beregnAreal() == 3.1415) {
            System.out.println("Test 3 - OK");
        } else {
            System.out.println("Test 3 - Feil");
        }

        // Test 4:
        if (figur2.beregnOmkrets() == 2*3.1415) {
            System.out.println("Test 4 - OK");
        } else {
            System.out.println("Test 4 - Feil");
        }
    }
}