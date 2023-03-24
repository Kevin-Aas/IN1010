public class TestButikk {
    
    public static void main(String[] args) {

        Person person1 = new Person("Pelle", "Ost");
        Person person2 = new Person("Kjetil", "Smør");
        Person person3 = new Person("Knut", "Sjokolade");
        Person person4 = new Person("Svein", "Øl");

        Butikk rimi = new Butikk();

        rimi.entreButikk(person1);
        rimi.entreButikk(person2);
        rimi.entreButikk(person3);
        rimi.entreButikk(person4);

        for (Person pers : rimi) {
            System.out.println(pers);
        }
    }
}
