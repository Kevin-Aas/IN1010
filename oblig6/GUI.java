import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GUI {
        Kontroll kontroll;
        JFrame vindu;
        JLabel levendeTekst;
        JPanel toppPanel, ruterPanel;
        JButton start, stopp, reset;
        int ANTALL_RADER;
        int ANTALL_KOLONNER;
        JButton[][] rutenett;
        int antallLevende;
        boolean trykketStart;
        
        public GUI(Kontroll kontroll, int ANTALL_RADER, int ANTALL_KOLONNER) {
            this.kontroll = kontroll;
            this.ANTALL_RADER = ANTALL_RADER;
            this.ANTALL_KOLONNER = ANTALL_KOLONNER;
            rutenett = new JButton[ANTALL_RADER][ANTALL_KOLONNER];
            trykketStart = false;

            try {
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                System.exit(0);
            }

            vindu = new JFrame("GAME OF LIFE");
            vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            vindu.setLayout(new BorderLayout());

            // Setter opp topp panelet med antall og start, stopp og reset knapp:
            toppPanel = new JPanel();
            toppPanel.setLayout(new FlowLayout());
            levendeTekst = new JLabel();
            levendeTekst.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            start = new JButton("Start");
            stopp = new JButton("Avslutt");
            reset = new JButton("Reset");
            start.setPreferredSize(new Dimension(90, 35));
            stopp.setPreferredSize(new Dimension(90, 35));
            reset.setPreferredSize(new Dimension(90, 35));
            start.addActionListener(new StartGame());
            stopp.addActionListener(new StoppGame());
            reset.addActionListener(new ResetGame());
            toppPanel.add(levendeTekst);
            toppPanel.add(start);
            toppPanel.add(reset);
            toppPanel.add(stopp);
            vindu.add(toppPanel, BorderLayout.PAGE_START);

            // Setter opp rutenettet med knapper:
            ruterPanel = new JPanel();
            ruterPanel.setLayout(new GridLayout(ANTALL_RADER, ANTALL_KOLONNER));
            Random rand = new Random();
            for (int rx=0; rx<ANTALL_RADER; rx++) {
                for (int kx=0; kx<ANTALL_KOLONNER; kx++) {
                    JButton rute = new JButton();
                    rute.addActionListener(new EndreStatus(rute));
                    rute.setBackground(Color.RED);
                    rutenett[rx][kx] = rute;
                    rute.setPreferredSize(new Dimension(20, 20));
                    if (rand.nextFloat() < 0.30) {
                        rute.setBackground(Color.GREEN);
                        antallLevende++;    // teller hvor mange som lever
                    }
                    ruterPanel.add(rute);
                }
            }
            vindu.add(ruterPanel, BorderLayout.CENTER);
            oppdaterLevende();

            // Pakker:
            vindu.pack();
            vindu.setLocationRelativeTo(null);
            vindu.setVisible(true);
        }

        public void oppdaterRutenett(boolean[][] modellRutenett) {
            // Brukes av kontrollen for aa oppdatere rutenettet
            // basert paa rutenettet (boolsk) som kommer av modellen.
            antallLevende = 0;
            for (int rx=0; rx<ANTALL_RADER; rx++) {
                for (int kx=0; kx<ANTALL_KOLONNER; kx++) {
                    if (modellRutenett[rx][kx]) {
                        rutenett[rx][kx].setBackground(Color.GREEN);
                        antallLevende++;
                    } else {
                        rutenett[rx][kx].setBackground(Color.RED);
                    }
                }
            }
            oppdaterLevende();
        }

        public boolean[][] hentRutenett() {
            // Benyttes av kontrollen for aa hente rutenettet fra GUIet
            // paa boolsk form som kan bli benyttet av modellen.
            boolean[][] boolskRutenett = new boolean[ANTALL_RADER][ANTALL_KOLONNER];
            for (int rx=0; rx<ANTALL_RADER; rx++) {
                for (int kx=0; kx<ANTALL_KOLONNER; kx++) {
                    // Sjekker om ruten er satt levende eller ikke:
                    if (rutenett[rx][kx].getBackground() == Color.GREEN) {
                        boolskRutenett[rx][kx] = true;
                    } else {
                        boolskRutenett[rx][kx] = false;
                    }
                }
            }
            return boolskRutenett;
        }

        public void oppdaterLevende() {
            // Oppdaterer teksten som viser antall som lever.
            levendeTekst.setText("Antall levende: "+antallLevende+"  ");
        }

        class StartGame implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Slik at man ikke kan trykke start flere ganger:
                if (!trykketStart) {
                    kontroll.start();
                    trykketStart = true;
                }
            }
        }

        class StoppGame implements ActionListener {
            // Avslutter programmet.
            @Override
            public void actionPerformed(ActionEvent e) {
                kontroll.avslutt();
            }
        }

        class ResetGame implements ActionListener {
            // Endrer fargene paa alle knappene tilfeldig, 
            // som resulterer til et resetet rutenett.
            Random rand = new Random();
            @Override
            public void actionPerformed(ActionEvent e) {
                antallLevende = 0;
                for (int rx=0; rx<ANTALL_RADER; rx++) {
                    for (int kx=0; kx<ANTALL_KOLONNER; kx++) {
                        if (rand.nextFloat() < 0.30) {
                            rutenett[rx][kx].setBackground(Color.GREEN);
                            antallLevende++;
                        } else {
                            rutenett[rx][kx].setBackground(Color.RED);
                        }
                    }
                }
                oppdaterLevende();
            }
        }

        class EndreStatus implements ActionListener {
            // Endrer fargen paa knappen til det motsatte.
            JButton rute;
            public EndreStatus(JButton rute) {
                this.rute = rute;
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rute.getBackground() == Color.GREEN) {
                    rute.setBackground(Color.RED);
                    antallLevende--;
                } else {
                    rute.setBackground(Color.GREEN);
                    antallLevende++;
                }
                oppdaterLevende();
            }
        }
}