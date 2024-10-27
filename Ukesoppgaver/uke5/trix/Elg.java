public class Elg implements Planteetere {
    
    public boolean beskytt() {
        if (Math.random() < 0.5) {
            System.out.println("Elgen beskytter seg selv");
            return true;
        } else {
            System.out.println("Elgen beskytter ikke seg selv");
            return false;
        }
    }

    public String toString() {return "Elg";}

}