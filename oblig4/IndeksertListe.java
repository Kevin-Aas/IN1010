public class IndeksertListe <E> extends Lenkeliste <E> {
    public void leggTil(int pos, E x) {
        if (pos < 0) {
            throw new UgyldigListeindeks(-1);
        } else if (pos > stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        } 
        if (antElementer == 0) {
            // Hvis listen er tom:
            start = new Node(x);
        } else if (antElementer == pos) {
            // Hvis man ønsker å legge til slutten av listen:
            Node gjeldene = start;
            for (int i=0; i<pos-1; i++) {
                gjeldene = gjeldene.neste;
            }
            gjeldene.neste = new Node(x);
        } else {
            Node gjeldene = start;
            for (int i=0; i<pos; i++) {
                gjeldene = gjeldene.neste;
            }
            Node ny = new Node(gjeldene.data);
            ny.neste = gjeldene.neste;
            gjeldene.data = x;
            gjeldene.neste = ny;
        }
        antElementer++;
    }

    public void sett(int pos, E x) {
        if (pos < 0) {
            throw new UgyldigListeindeks(-1);
        } else if (pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }
        Node gjeldene = start;
        for (int i=0; i<pos; i++) {
            gjeldene = gjeldene.neste;
        }
        gjeldene.data = x;
    }

    public E hent(int pos) {
        if (pos < 0) {
            throw new UgyldigListeindeks(-1);
        } else if (pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }
        Node gjeldene = start;
        for (int i=0; i<pos; i++) {
            gjeldene = gjeldene.neste;
        }
        return gjeldene.data;
    }

    public E fjern(int pos) {
        if (pos < 0) {
            throw new UgyldigListeindeks(-1);
        } else if (pos >= stoerrelse()) {
            throw new UgyldigListeindeks(pos);
        }
        Node gjeldene = start;
        for (int i=0; i<pos; i++) {
            gjeldene = gjeldene.neste;
        }
        Node vedPos = gjeldene;
        gjeldene = gjeldene.neste;
        antElementer--;
        return vedPos.data;
    }


}
