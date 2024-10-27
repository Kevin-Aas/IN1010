class RektangelHovedprogram {

    public static void main(String[] args) {

        Rektangel rektangel1 = new Rektangel(2, 3);
        Rektangel rektangel2 = new Rektangel(3, 4);

        System.out.println("Areal til første rektangel: " + rektangel1.areal());
        System.out.println("Areal til andre rektangel: " + rektangel2.areal());

        rektangel1.oekLengde(3);
        rektangel2.oekBredde(3);

        System.out.println("Omkretsen til første rektangel: " + rektangel1.omkrets());
        System.out.println("Omkretsen til andre rektangel: " + rektangel2.omkrets());
    }
}