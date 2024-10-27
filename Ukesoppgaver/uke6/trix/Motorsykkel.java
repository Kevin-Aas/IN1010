public class Motorsykkel {
    private String regNr;
    private int motorStrlse;

    public Motorsykkel(String regNr, int motorStrlse) {
        this.regNr = regNr;
        this.motorStrlse = motorStrlse;
    }

    public String hentRegNr() {
        return regNr;
    }

    public int hentMotorStrlse() {
        return motorStrlse;
    }
}
