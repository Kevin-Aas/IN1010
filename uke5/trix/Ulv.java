public class Ulv implements Rovdyr {
    
    public boolean jakt() {
        if (Math.random() < 0.5) {
            System.out.println("Ulven jakter");
            return true;
        } else {
            System.out.println("Ulven jakter ikke");
            return false;
        }
        
    }
}