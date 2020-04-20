package szukaczTekstu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main extends JFrame {

    private Main() {
        initComponents();
    }

    private void initComponents() {
        this.setTitle("szukacz tekstu");
        this.setSize(900,900);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
//        this.getContentPane().add(obszarTekstowy);  to zostało zlikwidowane przez to poniżej
        this.getContentPane().add(przewijanie, BorderLayout.NORTH);
        obszarTekstowy.setFont(new Font(Font.MONOSPACED, 0b11001, 35));
        this.getContentPane().add(panelSzukania, BorderLayout.CENTER);
        panelSzukania.add(szukaj, BorderLayout.CENTER);
        tekstSzukany.setFont(new Font(Font.MONOSPACED, 0b11001, 35));
        panelSzukania.add(tekstSzukany, BorderLayout.SOUTH);
        panelSzukania.add(zamien);
        panelSzukania.add(etykietaNa);
        panelSzukania.add(nowyTekst);
        nowyTekst.setFont(new Font(Font.MONOSPACED, 0b11001, 35));

        szukaj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                poczatekSzukanego = obszarTekstowy.getText().indexOf(tekstSzukany.getText(), poczatekSzukanego + tekstSzukany.getText().length());
                if (poczatekSzukanego == -1) {
                    poczatekSzukanego = obszarTekstowy.getText().indexOf(tekstSzukany.getText());
                }
                if (poczatekSzukanego >= 0 && tekstSzukany.getText().length() > 0) {
                    obszarTekstowy.requestFocus();
                    obszarTekstowy.select(poczatekSzukanego, poczatekSzukanego + tekstSzukany.getText().length());
                }

            }


            private int poczatekSzukanego = 0;
            private int koniecSzukanego = 0;
        });

        zamien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (obszarTekstowy.getSelectionStart() != obszarTekstowy.getSelectionEnd()) {
                    JOptionPane.showConfirmDialog(rootPane,"czy zamienic?  "+ tekstSzukany.getText()+ "\" na " +nowyTekst.getText(),
                             "Uwaga, nastapi zmiana", JOptionPane.YES_NO_CANCEL_OPTION);
                    obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());
                } else {
                    szukaj.doClick();
                    obszarTekstowy.replaceRange(nowyTekst.getText(), obszarTekstowy.getSelectionStart(), obszarTekstowy.getSelectionEnd());
                }


            }
        });

//        obszarTekstowy.selectAll();
//        obszarTekstowy.select(0,3);
//        String s = "jakis";
//        obszarTekstowy.replaceSelection(s);
//        obszarTekstowy.replaceRange("coś", 5,6);
//        obszarTekstowy.insert("string w wybranym miejscu", 23);
//        obszarTekstowy.append("dokłada do końca coś");
        obszarTekstowy.select(obszarTekstowy.getText().indexOf("test"), obszarTekstowy.getText().indexOf("test") + "test".length());
        //powyższy tekst zaznacza nam wybrane słowo
    }

    private JTextArea obszarTekstowy = new JTextArea("to jest testowy tekst", 7, 10);
    private JScrollPane przewijanie = new JScrollPane(obszarTekstowy);
    private JPanel panelSzukania = new JPanel();
    private JButton szukaj = new JButton("szukaj");
    private JTextField tekstSzukany = new JTextField(10);
    private JTextField nowyTekst = new JTextField(10);
    private JLabel etykieta = new JLabel("i");
    private JButton zamien = new JButton("zamien");
    private JLabel etykietaNa = new JLabel("na");

    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}