import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.HashMap;
import java.util.ArrayList;

public class Monitor2 {
    SubsekvensRegister register = new SubsekvensRegister();
    static Lock laas = new ReentrantLock();

    public ArrayList<HashMap<String, Subsekvens>> hentUtTo(){
        laas.lock();
        try {
            if (register.storrelse() < 2) {
                return null;
            }
            ArrayList<HashMap<String, Subsekvens>> hashmapPar = new ArrayList<>();
            hashmapPar.add(register.taUt(0));
            hashmapPar.add(register.taUt(0));
            return hashmapPar;
        }
        finally {
            laas.unlock();
        }
    }

    public void settInnFlettet(ArrayList<HashMap<String, Subsekvens>> hashmapPar) {       
        laas.lock();
        try {
            HashMap<String, Subsekvens> hashmap1 = hashmapPar.get(0);
            HashMap<String, Subsekvens> hashmap2 = hashmapPar.get(1);
            register.settInn(SubsekvensRegister.sammenslaa(hashmap1, hashmap2));
        }
        finally {
            laas.unlock();
        }
    }

    public void settInn(HashMap<String, Subsekvens> hashmap) {
        laas.lock();
        try {
            register.settInn(hashmap);
        }
        finally {
            laas.unlock();
        }
    }

    public HashMap<String, Subsekvens> taUt(int index) {
        laas.lock();
        try {
            return register.taUt(index);
        }
        finally {
            laas.unlock();
        }
    }

    public int storrelse() {
        laas.lock();
        try {
            return register.storrelse();
        }
        finally {
            laas.unlock();
        }
    }

    public static HashMap<String, Subsekvens> lesfil(String filnavn) {
        laas.lock();
        try {
            return SubsekvensRegister.lesfil(filnavn);
        }
        finally {
            laas.unlock();
        }
    }

    public static HashMap<String, Subsekvens> sammenslaa(HashMap<String, Subsekvens> hashmap1, 
                                                         HashMap<String, Subsekvens> hashmap2)
    {
        laas.lock();
        try {
            return SubsekvensRegister.sammenslaa(hashmap1, hashmap2);
        }
        finally {
            laas.unlock();
        }
    }
}
