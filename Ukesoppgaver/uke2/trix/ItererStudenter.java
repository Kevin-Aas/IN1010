import java.util.HashMap;

public class ItererStudenter {

    HashMap<String, Student> studenter = new HashMap<String, Student>();

    // a)
    for (String navn : studenter.keySet()){
        System.out.println(navn);
    }

    // b)
    for (Student student : studenter.values()){
        String navn = student.toString();
        System.out.println(navn);
    }
}