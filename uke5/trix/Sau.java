public class Sau implements Planteetere {
    
    public boolean beskytt() {
        if (Math.random() < 0.5) {
            System.out.println("Sauen beskytter seg selv");
            return true;
        } else {
            System.out.println("Sauen beskytter ikke seg selv");
            return false;
        }
    }

    public String toString() {return "Sau";}
}