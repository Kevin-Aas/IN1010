//import java.util.ArrayList;
import java.util.HashMap;

class Telefonbok2 {
    public static void main(String[] args){
        Person person1 = new Person("Karre Jacobsen", "97683244", "Bergenveien 43");
        Person person2 = new Person("Nils Fremrud", "96328953", "Olafiaveien 21");
        Person person3 = new Person("Rikke Hansen", "45827462", "Bukkveien 6");

        // Person[] personer = new Person[10];
        // personer[0] = person1;
        // personer[1] = person2;
        // personer[2] = person3;

        // ArrayList<Person> personer = new ArrayList<Person>();
        // personer.add(person1);
        // personer.add(person2);
        // personer.add(person3);
        
        // for (Person person : personer){
        //     if (person != null){
        //         person.skrivInfo();
        //     }
        // }
        
        HashMap<String, Person> personer = new HashMap<String, Person>();
        personer.put(person1.hentNavn(), person1);
        personer.put(person2.hentNavn(), person2);
        personer.put(person3.hentNavn(), person3);

        for (Person person : personer.values()){
            person.skrivInfo();
        }

    }
} 