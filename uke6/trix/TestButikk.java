public class TestButikk {
    
    public static void main(String[] args) {

        Person person1 = new Person("Kevin", "skrivebøker");
        Person person2 = new Person("Sylvia", "godteri");
        Person person3 = new Person("Steinar", "kjøkkenredskaper");
        Person person4 = new Person("Haakon", "sushi");
        Person person5 = new Person("Adéle", "iskrem");

        person1.settNeste(person2);
        person2.settNeste(person3);
        person3.settNeste(person4);
        person4.settNeste(person5);

        Butikk coopObs = new Butikk();
        coopObs.entreButikk(person1);

        coopObs.kassa();
    }
}
