public class Bjorn implements Rovdyr {
    
    public boolean jakt() {
        if (Math.random() < 0.5) {
            System.out.println("Bjornen jakter");
            return true;
        } else {
            System.out.println("Bjornen jakter ikke");
            return false;
        }
    }
}