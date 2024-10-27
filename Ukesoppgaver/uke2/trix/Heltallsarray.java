class Heltallsarray {
    public static void main(String[] args){
        int tall1 = 0;
        int tall2 = 1;
        int tall3 = 2;
        int tall4 = 3;
        int tall5 = 4;
        System.out.println(tall1);
        System.out.println(tall2);
        System.out.println(tall3);
        System.out.println(tall4);
        System.out.println(tall5);

        int[] tall = new int[5];
        
        for (int i=0; i<5; i++){
            tall[i] = i;
        }

        for (int tallet : tall){
            System.out.println(tallet);
        }
    
    }
}