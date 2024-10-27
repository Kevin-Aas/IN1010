class Bil {

    private String eier;
    private String merke;

    public Bil(String e, String m) {
        eier = e;
        merke = m;
    }

    public void bilMelding() {
        System.out.println("Eier: " + eier + ", merke: " + merke);
    }
}