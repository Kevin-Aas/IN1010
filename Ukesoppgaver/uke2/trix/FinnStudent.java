import java.util.HashMap;

public class FinnStudent {
    HashMap<String, String> studenter;

    // Alternativ 1:
    public boolean finnStudent(String navn){
        for (String student : studenter.keySet()){
            if (student.equals(navn)){
                return true;
            }         
        }
        return false;
    }

    // Alternativ 2:
    public boolean finnStudent2(String navn){
        return studenter.containsKey(navn);
    }

    // Alternativ 3:
    public boolean finnStudent3(String navn){
        if (studenter.containsKey(navn)){
            return true;
        }
        return false;
    }
}