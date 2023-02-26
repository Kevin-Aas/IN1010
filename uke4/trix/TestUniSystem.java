public class TestUniSystem {
    public static void main(String[] args) {
        // Lager studenter:
        BacholerStudent s1 = new BacholerStudent("Kevin", 25, "Fysikk og Astronomi");
        BacholerStudent s2 = new BacholerStudent("Sylvia", 25, "Informasjonsteknologi");
        MasterStudent s3 = new MasterStudent("Simen", 27, "Økonomi");

        // Tester metodene til studentene:
        s1.skrivUt();
        s2.skrivUt();
        s3.skrivUt();

        // Lager ansatte:
        Forsker a1 = new Forsker("Kyouma", 20, 0, "Tidreise");
        Forsker a2 = new Forsker("Cristina", 19, 3, "Nevrovitenskap");
        Professor a3 = new Professor("Theodor", 35, 5, "Kvantefysikk", "FYS2140");

        // Tester metodene til de ansatte:
        a1.skrivUt();
        a2.skrivUt();
        a3.skrivUt();
    }
}
