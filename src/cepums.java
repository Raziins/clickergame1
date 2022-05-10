import java.awt.*;
import java.awt.event.*;
import java.util.TimerTask;
import java.util.Timer;
import javax.swing.*;

public class cepums {

    public static void main(String[] args) {

        // UZTAISA FRAME
        Frame f = new Frame("clicker game");
        f.setSize(400, 400);
        f.setLayout(null);
        f.setVisible(true);

        // LABELI PRIEKS NAUDAS SKAITISANAS
        JLabel nauda;
        JLabel cpst;
        JLabel cpc;
        JLabel kursors;
        nauda = new JLabel();
        nauda.setBounds(500, 20, 300, 90);
        nauda.setFont(new Font("cepumuteksts", Font.BOLD, 35));
        f.add(nauda);
        cpst = new JLabel();
        cpst.setBounds(500, 80, 150, 45);
        cpst.setFont(new Font("cepumuteksts", Font.BOLD, 20));
        f.add(cpst);
        cpc = new JLabel();
        cpc.setBounds(500, 110, 150, 45);
        cpc.setFont(new Font("cepumuteksts", Font.BOLD, 20));
        f.add(cpc);
        kursors = new JLabel();
        kursors.setText("☞");
        kursors.setFont(new Font("cepumuteksts", Font.BOLD, 80));
        

        // Taimeris veic darbibu katru sekundi

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                mainigie.cepumi = mainigie.cepumi + mainigie.cps + mainigie.cursorcps;
                mainigie.combcps = mainigie.cps + mainigie.cursorcps;
                nauda.setText("cepumi:" + mainigie.cepumi);
                cpst.setText("cps:" + mainigie.combcps);
                cpc.setText("cpc:" + mainigie.cepumiplus);
            }
        }, 1000, 1000);

        // GALVENA CEPUMA POGA UN VISAS PAREJAS VEIKALA POGAS
        JButton b = new JButton(new ImageIcon("cepumabilde.png")); // galvenais cepums
        f.add(b);
        JButton bplus = new JButton("+1 par klikšķi (" + mainigie.cena1 + "c)"); // klikšķa plusošana
        f.add(bplus);
        JButton b1 = new JButton("+1 cepums sekunde (" + mainigie.cena2 + "c)"); // 1. cps upgrade
        f.add(b1);
        JButton b2 = new JButton("+2 cepums sekunde (" + mainigie.cena3 + "c)"); // 2. cps upgrade
        f.add(b2);
        JButton b3 = new JButton("+4 cepums sekunde (" + mainigie.cena4 + "c)"); // 3. cps upgrade
        f.add(b3);
        JButton b4 = new JButton("Auto clicker 1/s (" + mainigie.cena5 + "c)"); // auto clicker upgrade
        f.add(b4);
        b.setBounds(0, 0, 500, 500);
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // action listeners kurs pieskaita cepumus par katru klikšķi
                mainigie.cepumi = mainigie.cepumi + mainigie.cepumiplus;
                nauda.setText("cepumi:" + mainigie.cepumi);
                if (b.isSelected()) {
                    mainigie.cepumi = mainigie.cepumi + mainigie.cepumiplus;
                    nauda.setText("cepumi:" + mainigie.cepumi);
                }
            }
        });
        b1.setBounds(900, 150, 200, 30);
        b1.addActionListener(new ActionListener() { // action listeners 1 cps upgrade
            public void actionPerformed(ActionEvent e) {
                if (mainigie.cepumi >= mainigie.cena2) {
                    mainigie.cps++;
                    mainigie.cepumi = mainigie.cepumi - mainigie.cena2;
                    mainigie.cena2 = mainigie.cena2 * 2;
                    b1.setText("+1 cepums/sec (" + mainigie.cena2 + "c)");
                    nauda.setText("cepumi:" + mainigie.cepumi);

                }
            }
        });
        b2.setBounds(900, 200, 200, 30);
        b2.addActionListener(new ActionListener() { // action listeners 2 cps upgrade
            public void actionPerformed(ActionEvent e) {
                if (mainigie.cepumi >= mainigie.cena3) {
                    mainigie.cps = mainigie.cps + 2;
                    mainigie.cepumi = mainigie.cepumi - mainigie.cena3;
                    mainigie.cena3 = mainigie.cena3 * 2;
                    b2.setText("+2 cepums/sec (" + mainigie.cena3 + "c)");
                    nauda.setText("cepumi:" + mainigie.cepumi);

                }
            }
        });
        b3.setBounds(900, 250, 200, 30);
        b3.addActionListener(new ActionListener() { // action listeners 3 cps upgrade
            public void actionPerformed(ActionEvent e) {
                if (mainigie.cepumi >= mainigie.cena4) {
                    mainigie.cps = mainigie.cps + 4;
                    mainigie.cepumi = mainigie.cepumi - mainigie.cena4;
                    mainigie.cena4 = mainigie.cena4 * 2;
                    b3.setText("+4 cepums/sec (" + mainigie.cena4 + "c)");
                    nauda.setText("cepumi:" + mainigie.cepumi);

                }
            }
        });
        b4.setBounds(900, 300, 200, 30);
        b4.addActionListener(new ActionListener() { // action listeners auto clickerim
            public void actionPerformed(ActionEvent e) {
                if (mainigie.cepumi >= mainigie.cena5) {
                    mainigie.cursors++;
                    mainigie.test = mainigie.cursorcps;
                    mainigie.cursorcps = mainigie.cursors * mainigie.cepumiplus;
                    mainigie.cepumi = mainigie.cepumi - mainigie.cena5;
                    mainigie.cena5 = mainigie.cena5 * 2;
                    b4.setText("Auto clicker 1/s (" + mainigie.cena5 + "c)");
                    nauda.setText("cepumi:" + mainigie.cepumi);
                    kursors.setBounds(mainigie.x, 300, 1000, 1000);
                    f.add(kursors);

                }
            }
        });
        bplus.setBounds(900, 100, 200, 30);
        bplus.addActionListener(new ActionListener() { // action listeners klikšķa plusošanas pogai
            public void actionPerformed(ActionEvent e) {
                if (mainigie.cepumi >= mainigie.cena1) {
                    mainigie.cepumiplus++;
                    mainigie.cepumi = mainigie.cepumi - mainigie.cena1;
                    mainigie.cena1 = mainigie.cena1 * 3;
                    bplus.setText("+1 par klikšķi (" + mainigie.cena1 + "c)");
                    nauda.setText("cepumi:" + mainigie.cepumi);
                    if (mainigie.cursors >= 1) {
                        mainigie.cursorcps = mainigie.cursors * mainigie.cepumiplus;
                    }
                }

            }
        });

    }

}

// public static boolean enoughcookies(int currentcookies, int requiredcookies){
// if (currentcookies>=requiredcookies) {
// return true;
// } else {
// return false;
//