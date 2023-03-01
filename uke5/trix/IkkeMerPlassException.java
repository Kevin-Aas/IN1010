public class IkkeMerPlassException extends Exception {
    
    public IkkeMerPlassException(String tekst) {
        super("Ikke mer plass til '" + tekst + "'");
    }
}
