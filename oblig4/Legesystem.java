import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class Legesystem {

    // Omdefinerer println og print for aa gjore livet enklere:
    public static void println(Object o) {
        System.out.println(o);
    }
    public static void print(Object o) {
        System.out.print(o);
    }

    public static void main(String[] args) {
        Scanner brukerInput = new Scanner(System.in);

        // Starter programmet med aa sporre etter navnet paa en legedata fil:
        while (true) {
            print("\nVelg legesystemfil (filnavn.txt): ");
            String filnavn = inputFilnavn(brukerInput);
            try {
                lesData(filnavn);
                break;
            } catch (IOException e) {
                // Hvis filen ikke finne
                println(e.getMessage());
            }
        }
        
        println("\nLegesystem kjorer ...\n");
        println("\nVelkommen!\n");

        // Hovedmeny. Programmet returnerer hit etter undermenyene er ferdig utfort
        while (true) {
            println("+++++++++++++++++++++++++++++++");
            println("++++++++++ Hovedmeny ++++++++++");
            println("+++++++++++++++++++++++++++++++");
            println("0: Oversikt over alt i systemet");
            println("1: Legg til nye elementer");
            println("2: Bruk resepter");
            println("3: Statistikk");
            println("4: Skriv til fil");
            println("5: Avslutt");
            print("Svar: ");
            int svarHovedmeny = inputIntSvar(brukerInput, 6);
            print("\033[H\033[2J"); // Gjor konsollen mer oversiktlig

            // Kjorer de ulike metodene bestemt av valget i hovedmenyen:
            switch (svarHovedmeny) {
                case 0: kjorOversikt();
                    break;
                case 1: kjorLeggTil(brukerInput);
                    break;
                case 2: kjorBrukResept(brukerInput);
                    break;
                case 3: kjorStatistikk(brukerInput);
                    break;
                case 4: kjorSkrivFil(brukerInput);
                    break;
                case 5: 
                    // Avslutter programmet
                    println("\n... Legesystem avsluttet.");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    // Indeksertelister for elementene i systemet:
    // Disse blir fylt opp ved innlesing av fil samt ved opprettelse av
    // nye elementer.
    static IndeksertListe<Pasient> pasienter = new IndeksertListe<>();
    static IndeksertListe<Legemiddel> legemidler = new IndeksertListe<>();
    static IndeksertListe<Lege> leger = new IndeksertListe<>();

    // Disse input metodene spor om svar fra bruker samt tester om 
    // svaret er gyldig eller ikke:
    public static int inputInt(Scanner brukerInput) {
        // Sjekker om svaret fra brukeren er en int
        // ved aa teste om svaret kan omformes eller ikke.
        // Blir brukt for f.eks. 'Pris [NOK]: '
        while (true) {
            String svar = brukerInput.nextLine();
            try {
                int svarInt = Integer.parseInt(svar);
                return svarInt;
            } catch (NumberFormatException e) {
                println("Vennligst oppgi et heltall");
            }
            print("Svar: ");
        }
    }
    public static int inputIntSvar(Scanner brukerInput, int antallAlt) {
        // Tilsvarende som inputInt, men med forskjellig println argumenter.
        // Blir brukt hvor det er flere valg mulighete, som f.eks. i Hovedmenyen
        while (true) {
            String svar = brukerInput.nextLine();
            try {
                int svarInt = Integer.parseInt(svar);
                if (svarInt < antallAlt) {
                    return svarInt;
                } else {
                    println("Vennligst velg et av alternativene (0 til "+(antallAlt-1)+")");
                }
            } catch (NumberFormatException e) {
                println("Vennligst oppgi ett heltall mellom 0 og "+(antallAlt-1));
            }
            print("Svar: ");
        }
    }
    public static String inputString(Scanner brukerInput) {
        // Denne passer paa at strengen ikke er tom.
        // Blir brukt hovedsakelig for navn, som f.eks. pasientnavn
        while (true) {
            String svar = brukerInput.nextLine().trim();
            if (!svar.isEmpty()) {
                return svar;
            }
            print("Vennligst oppgi en streng: ");
        }
    }
    public static double inputDouble(Scanner brukerInput) {
        // Det samme som inputInt, men bare for Double.
        // Blir kun brukt ved virkestoff
        while (true) {
            String svar = brukerInput.nextLine();
            try {
                double svarDouble = Double.parseDouble(svar);
                return svarDouble;
            } catch (NumberFormatException e) {
                println("Vennligst oppgi et tall");
            }
        }
    } 
    public static String inputDrNavn(Scanner brukerInput) {
        // Passer paa at navnet til nye leger starter med "Dr. "
        while (true) {
            String svar = brukerInput.nextLine();
            String[] svarSplit = svar.split(" ");
            if (svarSplit[0].equals("Dr.")) {
                return svar.trim();
            }
            println("Feil navnform!");
            print("Navn paa lege: ");
        }
    }
    public static String inputSpesialist(Scanner brukerInput) {
        // Sjekker om brukeren avgir "j" eller "n" naar det blir spurt
        // om legen er spesialist eller ikke.
        while (true) {
            String svar = brukerInput.nextLine().trim();
            if (svar.equals("j") || svar.equals("n")) {
                return svar;
            }
            print("Velg enten ja(j) eller nei(n):");
        }
    }
    public static String inputFilnavn(Scanner brukerInput) {
        while (true) {
            // Denne passer paa at filnavnet slutter med ".txt".
            // Blir brukt paa starten av programmet og ved opprettelsen
            // av ny fil.
            String svar = brukerInput.nextLine().trim();
            try {
                String[] svarSplit = svar.split("\\.");
                if (svarSplit[1].equals("txt")) {
                    return svar;
                }
                println("Feil form paa filnavn!");
                print("Filnavn: ");
            } catch (ArrayIndexOutOfBoundsException e) {
                println("Feil form paa filnavn!");
                print("Filnavn: ");
            }
            
        }
    }

    // Dette er metodene som blir kjort ved valg i hovedmenyen:
    public static void kjorOversikt() {
        println("\n******************************** Oversikt ********************************\n");
        println("--------------- Pasienter ---------------");
        println("       Navn         |       Fodselsnr    ");
        println("------------------- + -------------------");
        for (Pasient pasient : pasienter) {
            System.out.printf("  %-18s|%17s\n",
                    pasient.hentNavn(),pasient.hentFodselsnr());
        }
        println("-----------------------------------------");
        println("\n-------- Leger --------");
        for (Lege lege : leger) {
            println(lege);
        }
        println("-----------------------");
        println("\n------------------------- Legemidler -------------------------");
        println("          Navn        | Pris [NOK] | Virkestoff [mg] | Styrke");
        println("--------------------- + ---------- + --------------- + -------");
        for (Legemiddel lm : legemidler) {
            if (lm instanceof Vanlig) {
                System.out.printf("%-22s|%-12s|%s\n",
                        lm.hentNavn(),lm.hentPris(),lm.hentVirkestoff());
            } else {
                if (lm instanceof Vanedannede) {
                    Vanedannede vlm = (Vanedannede) lm;
                    System.out.printf("%-22s|%-12s|%-17s|%s\n",
                        lm.hentNavn(),lm.hentPris(),lm.hentVirkestoff(),vlm.hentStyrke());
                } else if (lm instanceof Narkotisk) {
                    Narkotisk nlm = (Narkotisk) lm;
                    System.out.printf("%-22s|%-12s|%-17s|%s\n",
                        lm.hentNavn(),lm.hentPris(),lm.hentVirkestoff(),nlm.hentStyrke());
                }
            }
        }
        println("--------------------------------------------------------------");
        println("\n-------------------------------- Resepter ---------------------------------");
        println(" Nr. |     Legemiddel     |   Utskrivende lege   |   Pasient navn   | Reit");
        println("---- + ------------------ + -------------------- + ---------------- + -----");
        int i = 1;
        for (Lege lege : leger) {
            for (Resept resept : lege.hentUtskrevneResepter()) {
                System.out.printf("  %d  | %-18s | %-20s | %-16s | %s\n", i,
                    resept.hentLegemiddel().hentNavn(), resept.hentLege(),
                    resept.hentPasient().hentNavn(), resept.hentReit());
                i++;
            }
        }
        println("---------------------------------------------------------------------------");
        println("");
    }
    public static void kjorLeggTil(Scanner brukerInput) {
        println("\nHva vil du legge til? ");
        println("0: Lege");
        println("1: Pasient");
        println("2: Resept");
        println("3: Legemiddel");
        print("Svar: ");
        int svarLeggTil = inputIntSvar(brukerInput, 4);
        println("");

        if (svarLeggTil == 0) {
            // **Lage ny lege**
            print("Navn paa lege (Dr. etternavn): ");
            String svarNavn = inputDrNavn(brukerInput);
            print("Spesialist? [j/n]: ");
            String svarSpesialist = inputSpesialist(brukerInput);
            if (svarSpesialist.equals("n")) {
                leggTilSortertLege(new Lege(svarNavn));
                println("Ny lege lagt til!");
            } else {
                print("Kontrollkode: ");
                String svarKontrollkode = inputString(brukerInput);
                leggTilSortertLege(new Spesialist(svarNavn, svarKontrollkode));
                println("Ny spesialist lagt til!");
            }
            println("");

        } else if (svarLeggTil == 1) {
            // **Lage ny pasient**
            print("Navn på pasient: ");
            String svarNavn = inputString(brukerInput);
            print("Fodselsnr: ");
            String svarFodselsnr = inputString(brukerInput);
            pasienter.leggTil(new Pasient(svarNavn, svarFodselsnr));
            println("Ny pasient lagt til!");
            println("");

        } else if (svarLeggTil == 2) {
            // **Lage ny resept**
            println("Hvilket legemiddel? ");
            int antAlt = 0;
            // Lager svarsalternativ liste:
            for (Legemiddel lm : legemidler) {
                println(lm.id+": "+lm.hentNavn());
                antAlt++;
            }
            print("Svar: ");
            // og tar inn svar:
            int svarLmId = inputIntSvar(brukerInput, antAlt);
            Legemiddel svarLm = legemidler.hent(svarLmId);

            println("\nUtskrivendelege? ");
            antAlt = 0;
            // Lager svarsalternativ liste:
            for (Lege lege : leger) {
                if (lege instanceof Spesialist) {
                    println(antAlt+": "+lege.hentNavn()+" (S)");
                } else {
                    println(antAlt+": "+lege.hentNavn());
                }
                antAlt++;
            }
            print("Svar: ");
            // og tar inn svar:
            int svarLegeId = inputIntSvar(brukerInput, antAlt);
            Lege svarLege = leger.hent(svarLegeId);

            println("\nFor hvilken pasient? ");
            antAlt = 0;
            // Lager svarsalternativ liste:
            for (Pasient pasient : pasienter) {
                println(pasient.pasientId+ ": " + pasient.hentNavn() 
                            + " (Fodselsnr: " +pasient.hentFodselsnr()+ ")");
                antAlt++;
            }
            print("Svar: ");
            // og tar inn svar:
            int svarPasientId = inputIntSvar(brukerInput, antAlt);
            Pasient svarPasient = pasienter.hent(svarPasientId);

            println("\nHvilken type resept?");
            println("0: Hvit");
            println("1: Blaa");
            println("2: Militear");
            println("3: P");
            print("Svar: ");
            antAlt = 4;
            int svarRtype = inputIntSvar(brukerInput, antAlt);
            println("");

            // Prover aa skrive resepter:
            if (svarRtype != 2) {
                // Ved ikke militaer resept:
                print("Antall reit: ");
                int svarReit = inputInt(brukerInput);
                if (svarRtype == 0) {
                    try {
                        svarLege.skrivHvitResept(svarLm, svarPasient, svarReit);
                        println("Ny hvit resept skrevet!");
                    } catch (UlovligUtskrift e) {
                        println(e.getMessage());
                    }
                } else if (svarRtype == 1) {
                    try {
                        svarLege.skrivBlaaResept(svarLm, svarPasient, svarReit);
                        println("Ny blaa resept skrevet!");
                    } catch (UlovligUtskrift e) {
                        println(e.getMessage());
                    }
                } else if (svarRtype == 3) {
                    try {
                        svarLege.skrivPResept(svarLm, svarPasient, svarReit);
                        println("Ny p-resept skrevet!");
                    } catch (UlovligUtskrift e) {
                        println(e.getMessage());
                    }
                }
            } else {
                // Ved militaer resept:
                try {
                    svarLege.skrivMilResept(svarLm, svarPasient);
                    println("Ny militear resept skrevet!");
                } catch (UlovligUtskrift e) {
                    println(e.getMessage());
                }
            }
            println("");

        } else if (svarLeggTil == 3) {
            // **Lage nytt legemiddel**
            println("Hviken type? ");
            println("0: Vanlig");
            println("1: Vanedannede");
            println("2: Narkotisk");
            print("Svar: ");
            int antAlt = 3;
            int svarLmType = inputIntSvar(brukerInput, antAlt);
            
            print("\nNavn paa legemiddel: ");
            String svarLmNavn = inputString(brukerInput);

            print("Pris [NOK]: ");
            int svarLmPris = inputInt(brukerInput);

            print("Virkestoff [mg]: ");
            double svarLmVstoff = inputDouble(brukerInput);
            
            // Legger til legemiddel:
            if (svarLmType != 0) {
                // Vanedannede eller narkotisk:
                print("Styrke: ");
                int svarLmStyrke = inputInt(brukerInput);
                if (svarLmType == 1) {
                    legemidler.leggTil(new Vanedannede(svarLmNavn, svarLmPris, svarLmVstoff, svarLmStyrke));
                    println("Nytt vanedannede legemiddel lagt til!");
                } else {
                    legemidler.leggTil(new Narkotisk(svarLmNavn, svarLmPris, svarLmVstoff, svarLmStyrke));
                    println("Nytt narkotisk legemiddel lagt til!");
                }   
            } else {
                // Vanlig:
                legemidler.leggTil(new Vanlig(svarLmNavn, svarLmPris, svarLmVstoff));
                println("Nytt vanlig legemiddel lagt til!");
            }
            println("");
        }
    }
    public static void kjorBrukResept(Scanner brukerInput) {
        println("\nHvilken pasient vil du se resepter for? ");
        int antAlt = 0;
        // Lager svarsalternativ liste:
        for (Pasient pasient : pasienter) {
            print(pasient.pasientId+": ");
            println(pasient.hentNavn() + " (Fodselsnr " + pasient.hentFodselsnr() +")");
            antAlt++;
        }
        print("Svar: ");
        // og tar inn svar:
        int svarPasientId = inputIntSvar(brukerInput, antAlt);
        Pasient svarPasient = pasienter.hent(svarPasientId);
        println("");
        
        // Sjekker forst om pasienten har noen resepter:
        if (svarPasient.hentResepter().stoerrelse() == 0) {
            println("Denne pasienten har ingen resepter.");
            println("Returnerer til hovedmeny...");
            println("");
            return;
        } else {
            println("Hvilken resept vil du bruke? ");
            antAlt = 0;
            // Lager svarsalternativ liste:
            for (Resept resept : svarPasient.hentResepter()) {
                println(antAlt+": "+resept.hentLegemiddel().hentNavn()+
                        " ("+resept.hentReit()+" reit)");
                antAlt++;
            }
            print("Svar: ");
            // og tar inn svar:
            int svarReseptId = inputIntSvar(brukerInput, antAlt);
            Resept svarResept = svarPasient.hentResepter().hent(svarReseptId);

            // Sjekker forst om resepten har fellere reit:
            if (svarResept.hentReit() == 0) {
                println("Kunne ikke bruke resept paa "+svarResept.hentLegemiddel().hentNavn()+
                        " (ingen gjenvaerende reit).");
            } else {
                svarResept.bruk();
                println("Brukte resept på "+svarResept.hentLegemiddel().hentNavn() +
                                ". Antall gjenvaerende reit: "+svarResept.hentReit());
            }
            println("");
        }
    }
    public static void kjorStatistikk(Scanner brukerInput) {
        println("\nVelg hvilken statestikk: ");
        println("0: Totalt antall utskrevne resepter på vanedannende legemidler");
        println("1: Totalt antall utskrevne resepter på narkotiske legemidler");
        println("2: Mulig misbruk av narkotika");
        println("3: Returner til hovedmeny");
        print("Svar: ");
        int antAlt = 4;
        int svarStat = inputIntSvar(brukerInput, antAlt);

        if (svarStat == 0) {
            int teller = 0;
            // Teller hvor mange vanedannede resepter som er blitt skrevet:
            for (Lege lege : leger) {
                for (Resept resept : lege.hentUtskrevneResepter()) {
                    if (resept.hentLegemiddel() instanceof Vanedannede) {
                        teller++;
                    }
                }
            }
            println("");
            if (teller == 0) {
                println("Det er ikke skrevet ut noen vanedannede resepter.");
            } else if (teller == 1) {
                println("Det er skrevet ut kun én vanedannede resept.");
            } else {
                println("Det er utskrevet " + teller + " vanedannende resepter.");
            }
            // For aa unngaa aa dra tilbake hovedmenyen:
            kjorStatistikk(brukerInput); 
            println("");

        } else if (svarStat == 1) {
            int teller = 0;
            // Teller hvor mange narkotiske resepter som er blitt skrevet:
            for (Lege lege : leger) {
                for (Resept resept : lege.hentUtskrevneResepter()) {
                    if (resept.hentLegemiddel() instanceof Narkotisk) {
                        teller++;
                    }
                }
            }
            println("");
            if (teller == 0) {
                println("Det er ikke skrevet ut noen narkotiske resepter.");
            } else if (teller == 1) {
                println("Det er skrevet ut kun én narkotisk resept.");
            } else {
                println("Det er utskrevet " + teller + " narkotiske resepter.");
            }
            // For aa unngaa aa dra tilbake hovedmenyen:
            kjorStatistikk(brukerInput);
            println("");

        } else if (svarStat == 2) {
            println("");
            for (Lege lege : leger) {
                int teller = 0;
                // Teller hvor mange narkotiske resepter hver lege har skrevet og 
                // printer dem ut hvis de har skrevet ut minst én narkotisk:
                for (Resept resept : lege.hentUtskrevneResepter()) {
                    if (resept.hentLegemiddel() instanceof Narkotisk) {
                        teller++;
                    }
                }
                if (teller == 1) {
                    println(lege + " har skrevet ut én narkotisk resept.");
                } else if (teller > 1) {
                    println(lege + " har skrevet ut "+teller+" narkotiske resepter.");
                }
            }
            for (Pasient pasient : pasienter) {
                int teller = 0;
                // Teller hvor mange narkotiske resepter hver pasient har og 
                // printer dem ut hvis de har minst én narkotisk:
                for (Resept resept : pasient.hentResepter()) {
                    if (resept.hentLegemiddel() instanceof Narkotisk) {
                        teller++;
                    }
                }
                if (teller == 1) {
                    println(pasient.hentNavn() + " har én narkotisk resept.");
                } else if (teller > 1) {
                    println(pasient.hentNavn() + " har "+teller+" narkotiske resepter.");
                }
            }
            // For aa unngaa aa dra tilbake hovedmenyen:
            kjorStatistikk(brukerInput);
            println("");

        } else {
            // Returnerer til hovedmenyen.
        }
    }
    public static void kjorSkrivFil(Scanner brukerInput) {
        // Denne metoden blir brukt hvis man onsker aa skrive systemet om til
        // en ny fil. Den folger samme format som vedlegg 2 i oppgaven. 
        // Den gaar igjennom alle de indeksertelistene, samt reseptlistene hos 
        // hver lege, og deretter lister opp den relevante infoen etter hverandre.
        // Den spor forst om onsket navn til filen og sjekker om den er ".txt":
        print("\nNavn paa fil (filnavn.txt): ");
        String filnavn = inputFilnavn(brukerInput);
        try {
            FileWriter nyFilSkriver = new FileWriter(filnavn);
            nyFilSkriver.write("# Pasienter (navn, fnr)\n");
            for (Pasient pasient : pasienter) {
                nyFilSkriver.write(pasient.hentNavn()+","+pasient.hentFodselsnr()+"\n");
            }
            nyFilSkriver.write("# Legemidler (navn,type,pris,virkestoff,[styrke])\n");
            for (Legemiddel lm : legemidler) {
                String lmType = "";
                // Finner ut om lm er narkotisk, vanedannede eller vanlig og
                // og printer for hver:
                if (lm instanceof Narkotisk) {
                    Narkotisk nlm = (Narkotisk) lm;
                    lmType = "narkotisk";
                    nyFilSkriver.write(lm.hentNavn()+","+lmType+","+
                                    lm.hentPris()+","+lm.hentVirkestoff()+","+
                                    nlm.hentStyrke()+"\n");
                } else if (lm instanceof Vanedannede) {
                    Vanedannede vlm = (Vanedannede) lm;
                    lmType = "vanedannede";
                    nyFilSkriver.write(lm.hentNavn()+","+lmType+","+
                                    lm.hentPris()+","+lm.hentVirkestoff()+","+
                                    vlm.hentStyrke()+"\n");
                } else {
                    lmType = "vanlig";
                    nyFilSkriver.write(lm.hentNavn()+","+lmType+","+
                                    lm.hentPris()+","+lm.hentVirkestoff()+"\n");
                }
            }
            nyFilSkriver.write("# Leger (navn,kontrollid / 0 hvis vanlig lege)\n");
            for (Lege lege : leger) {
                // Sjekker om lege er spesialist eller ikke (leger skal ha 0
                // som kontrollkode):
                if (lege instanceof Spesialist) {
                    Spesialist slege = (Spesialist) lege;
                    nyFilSkriver.write(lege.hentNavn()+","+
                                        slege.hentKontrollkode()+"\n");
                } else {
                    nyFilSkriver.write(lege.hentNavn()+",0\n");
                }
            }
            nyFilSkriver.write("# Resepter (legemiddelNummer,legeNavn,pasientID,type,[reit])\n");
            for (Lege lege : leger) {
                for (Resept resept : lege.hentUtskrevneResepter()) {
                    String type = "";
                    // Finner ut om resepten er blaa, hvit, militear eller p:
                    if (resept instanceof BlaaResept) {
                        type = "blaa";
                    } else if (resept instanceof HvitResept) {
                        type = "hvit";
                    } else if (resept instanceof MilResept) {
                        type = "militaer";
                    } else {
                        type = "p";
                    }
                    nyFilSkriver.write(resept.hentLegemiddel().id+","+lege.hentNavn()+
                                        ","+resept.hentPasient().hentPasientId()+
                                        ","+type+","+resept.hentReit()+"\n");
                }
            }
            println("'"+filnavn+"' er opprettet!");
            nyFilSkriver.close();
        } catch (Exception e) {
            println("Klarte ikke aa skrive fil.");
            println(e.getMessage());
        }
        println("");
    }

    // Metoden som leser filen oppgitt paa starten av programmet:
    public static void lesData(String filnavn) throws IOException{
        File fil = new File(filnavn);
        Scanner filleser = new Scanner(fil);
        int gruppe = 0;
        while (filleser.hasNextLine()) {
            String linje = filleser.nextLine();
            if (linje.charAt(0) == '#') {
                String[] linjeSplit = linje.split(" ");
                // Sjekker hvilke objekter som finner i de neste linjene:
                switch (linjeSplit[1]) {
                    case "Pasienter":   gruppe = 1; break;                                       
                    case "Legemidler":  gruppe = 2; break;                                   
                    case "Leger":       gruppe = 3; break;
                    case "Resepter":    gruppe = 4; break;                                
                    default:            gruppe = 0; break;
                }

            } else {
                // Vi befinner oss paa en linje som ikke starter med #

                if (gruppe == 1) {
                    // **Pasienter**
                    String[] pasientLinje = linje.split(",");
                    String navn = pasientLinje[0];
                    String fodselsnr = pasientLinje[1];
                    pasienter.leggTil(new Pasient(navn, fodselsnr));

                } else if (gruppe == 2) {
                    // **Legemidler**
                    String[] lmLinje = linje.split(",");
                    String navn = lmLinje[0];
                    String lmType = lmLinje[1];
                    int pris = Integer.parseInt(lmLinje[2]);
                    double virkestoff = Double.parseDouble(lmLinje[3]);
                    // Sjekker hvilken type legemiddelet er for aa lage et legemiddel av den
                    // typen og legger det til i legemidler-listen:
                    if (lmType.equals("narkotisk") || lmType.equals("vanedannende")) {
                        int styrke = Integer.parseInt(lmLinje[4]);
                        if (lmType.equals("narkotisk")) {
                            legemidler.leggTil(new Narkotisk(navn, pris, virkestoff, styrke));
                        } else {
                            legemidler.leggTil(new Vanedannede(navn, pris, virkestoff, styrke));
                        }
                    } else {
                        legemidler.leggTil(new Vanlig(navn, pris, virkestoff));
                    }

                } else if (gruppe == 3) {
                    // **Leger**
                    String[] legeLinje = linje.split(",");
                    String navn = legeLinje[0];
                    String kontrollkode = legeLinje[1].trim();
                    // Sjekker om spesialist eller ikke og legger deretter til leger-listen
                    // ved hjelp av leggTilSortertLege metoden:
                    if (kontrollkode.equals("0")) {
                        leggTilSortertLege(new Lege(navn));
                    } else {
                        leggTilSortertLege(new Spesialist(navn, kontrollkode));
                    }

                } else if (gruppe == 4) {
                    // **Resepter**
                    String[] reseptLinje = linje.split(",");
                    int lmNr = Integer.parseInt(reseptLinje[0]);
                    Legemiddel lm = null;
                    // Finner det legemiddelet med samme id:
                    for (Legemiddel legemiddel : legemidler) {
                        if (legemiddel.id == lmNr) {
                            lm = legemiddel;
                        }
                    }
                    String legeNavn = reseptLinje[1];
                    Lege lmLege = null;
                    // Finner legen med det samme navnet:
                    for (Lege lege : leger) {
                        if (lege.hentNavn().equals(legeNavn)) {
                            lmLege = lege;
                        }
                    }
                    int pasientId = Integer.parseInt(reseptLinje[2]);
                    Pasient lmPasient = null;
                    // Finner pasienten med samme id:
                    for (Pasient pasient : pasienter) {
                        if (pasient.pasientId == pasientId) {
                            lmPasient = pasient;
                        }
                    }
                    String reseptType = reseptLinje[3];
                    // Prover aa lage resept:
                    try {
                        if (!reseptType.equals("militaer")) {
                            int reit = Integer.parseInt(reseptLinje[4]);
                            if (reseptType.equals("hvit")) {
                                lmLege.skrivHvitResept(lm, lmPasient, reit);
                            } else if (reseptType.equals("blaa")) {
                                lmLege.skrivBlaaResept(lm, lmPasient, reit);
                            } else if (reseptType.equals("p")) {
                                lmLege.skrivPResept(lm, lmPasient, reit);
                            }
                        } else {
                            lmLege.skrivMilResept(lm, lmPasient);
                        }
                    } catch (UlovligUtskrift e) {
                        println(e.getMessage());
                    }
                }
            }
        }
        filleser.close();
    }

    // Denne metoden legger til leger slik at legelisten blir sortert: 
    public static void leggTilSortertLege(Lege nyLege) {
        for (int i=0; i<leger.stoerrelse(); i++) {
            if (leger.hent(i).compareTo(nyLege) >= 0) {
                leger.leggTil(i, nyLege);
                return;
            }
        }
        leger.leggTil(nyLege);
    }
}
