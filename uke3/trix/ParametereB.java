public class ParametereB {
    public static void main(String[] args){
        int b = 5;

        // metodeTo(b); gir error

        System.out.println(b);
    }

    public static int meotdeTo(int b) {
        b = b + 2;
        return b;
    }
}