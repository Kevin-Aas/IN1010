class TestBaathus {

    public static void main(String[] args) {

        Baathus baathus = new Baathus(3);

        Baat baat1 = new Baat("Yamaha");
        Baat baat2 = new Baat("Bayliner");
        Baat baat3 = new Baat("Regal");
        Baat baat4 = new Baat("Grady-White");

        baathus.settInn(baat1);
        baathus.settInn(baat2);
        baathus.settInn(baat3);
        baathus.settInn(baat4);
        
        baathus.skrivBaater();
    }
}