public class BilBruk3 {

    public static void main(String[] args){

        Bil3 bil1 = new Bil3("DN43275");
        Person person1 = new Person("Trond", bil1.hentNummer());
        person1.personMelding();

        Bil3 bil2 = new Bil3("EL29664");
        Person person2 = new Person("Silje", bil2.hentNummer());
        person2.personMelding();
    }
}