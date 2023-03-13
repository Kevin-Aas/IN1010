public class Prioritetskoe <E extends Comparable<E>> extends Lenkeliste <E> {
    @Override
    public void leggTil(E x) {
        if (antElementer == 0) {
            // Hvis listen er tom:
            start = new Node(x);
        } else {
            Node gjeldene = start;
            while (gjeldene.neste != null) {
                if (gjeldene.data.compareTo(x) > 0) {
                    Node ny = new Node(gjeldene.data);
                    ny.neste = gjeldene.neste;
                    gjeldene.data = x;
                    gjeldene.neste = ny;
                    antElementer++;
                    return;
                }
                gjeldene = gjeldene.neste;
            }
            if (antElementer == 1) {
                if (gjeldene.data.compareTo(x) > 0) {
                    Node ny = new Node(gjeldene.data);
                    ny.neste = gjeldene.neste;
                    gjeldene.data = x;
                    gjeldene.neste = ny;
                    antElementer++;
                    return;
                }
            }
            gjeldene.neste = new Node(x);
        }
        antElementer++;
    }

    // Trenger ikke å endre på hent og fjern metodene.
}
