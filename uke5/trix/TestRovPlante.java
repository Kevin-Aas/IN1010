public class TestRovPlante {
    
    public static void main(String[] args) {

        Bjorn svartBjorn = new Bjorn();
        Bjorn brunBjorn = new Bjorn();
        Ulv graaUlv = new Ulv();
        Elg kongeElg = new Elg();
        Sau hvitSau = new Sau();

        Rovdyr[] rovdyrliste = {svartBjorn, brunBjorn, graaUlv};
        Planteetere[] planteetereliste = {kongeElg, hvitSau};

        for (Rovdyr rd : rovdyrliste) {
            for (Planteetere pd : planteetereliste) {
                System.out.println("----------");
                if (rd.jakt()) {
                    if (pd.beskytt()) {
                        System.out.println(pd.toString() + "en overlever");
                    } else {
                        System.out.println(pd.toString() + "en blir spist");
                    }
                } else {
                    pd.beskytt();
                    System.out.println(pd.toString() + "en overlever");
                }
            }
        }

    }
}
