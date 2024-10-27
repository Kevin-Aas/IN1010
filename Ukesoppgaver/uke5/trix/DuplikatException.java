public class DuplikatException extends Exception {
    
    public DuplikatException(String tekst) {
        super("'" + tekst + "' finnes allerede (duplikat)");
    }
}
