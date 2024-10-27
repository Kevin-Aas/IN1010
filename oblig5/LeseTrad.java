public class LeseTrad implements Runnable {
    String filnavn;
    Monitor2 monitor;

    public LeseTrad(String filnavn, Monitor2 monitor) {
        this.filnavn = filnavn;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        monitor.settInn(Monitor2.lesfil(filnavn));
    }
}
