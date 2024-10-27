import java.util.ArrayList;
import java.util.HashMap;

public class FletteTrad implements Runnable {
    Monitor2 monitor;

    public FletteTrad(Monitor2 monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (monitor.storrelse() > 1) {
            ArrayList<HashMap<String, Subsekvens>> hashmapPar = monitor.hentUtTo();
            if (hashmapPar != null) {
                monitor.settInnFlettet(hashmapPar);
            }
        }
    }
}
