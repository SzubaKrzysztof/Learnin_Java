package pasek;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import static javax.swing.KeyStroke.*;

public class Main extends JFrame {


    public Main() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("");
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(900,600);
        this.setDefaultCloseOperation(3);
//        this.getContentPane().setLayout(new GridLayout(2,1));
        this.getContentPane().add(panel);
        this.getContentPane().add(pasekMenu, BorderLayout.NORTH);
        this.getContentPane().add(obszarTekstowy);
        obszarTekstowy.setSize(15, 40);
        obszarTekstowy.setFont(new Font(Font.MONOSPACED, 15, 20));
        this.getContentPane().add(panel2, BorderLayout.SOUTH);
        panel2.setLayout(new GridLayout(2, 1));
        panel2.setSize(15, 40);
        panel2.add(odblokuj);

        obszarTekstowy.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                if (tylkoDoOdczytu.isSelected()) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
//                if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_V && tylkoDoOdczytu.isSelected()) {        //tym sposobem mozemy wylaczyc wszytkie guziki jakie chcemy
                if (tylkoDoOdczytu.isSelected()) {
                    e.consume();
                } else if (!(obszarTekstowy.getText() + e.getKeyChar()).equals(przedZmianaObszaruTekstowego)) {
                    Zapisz.setEnabled(flagaObszaruTekstowego = true);

                }
            }
        });
        Zapisz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("zapisujemy na dysk");
                Zapisz.setEnabled(false);
            }
        });
        Edycja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("klikniecie w Edycja");
            }
        });
        Plik.addSeparator();

        //
        Zapisz.setEnabled(false);

        //
        Plik.addSeparator();
        JMenu Opcje = new JMenu("Opcje");
        Plik.add(Opcje);
        Opcje.add(new JMenuItem("1"));
        Opcje.add(new JMenuItem("2"));
        Opcje.add(new JMenuItem("3"));
        Opcje.add(tylkoDoOdczytu);
        tylkoDoOdczytu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tylkoDoOdczytu.isSelected()) {
                    Zapisz.setEnabled(false);
                }
            }
        });
        JMenu Pomoc = new JMenu("Pomoc");
        pasekMenu.add(Pomoc);
        Pomoc.add(new JMenuItem("O programie"));
        Pomoc.add(new JMenuItem("Kontakt"));
        JMenuItem Czytaj = Plik.add(new JMenuItem("Czytaj"));
        Plik.addSeparator();
        JMenuItem Zakoncz = Plik.add(new JMenuItem("Zakoncz"));
        Zapisz.setToolTipText("zapisanie pliku na dysku");                  //chmurka z podpowiedzią co robi dany element
        Zapisz.setMnemonic('z');




    }
//    private class  ActionSave extends AbstractAction{
//        public ActionSave(String nazwa){
//            this.putValue(Action);
//        }
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }
    private JMenuBar pasekMenu = new JMenuBar();
    JMenu Plik = pasekMenu.add(new JMenu("Plik"));
    JMenuItem Edycja = Plik.add(new JMenuItem("Edycja "));
    JCheckBoxMenuItem tylkoDoOdczytu = new JCheckBoxMenuItem("tylko do odczytu");
    final JMenuItem Zapisz = Plik.add(new JMenuItem("Zapisz"));
    private JButton odblokuj = new JButton("odblokuj");
    private JPanel panel = new JPanel();
    private JTextArea obszarTekstowy = new JTextArea();
    private JPanel panel2 = new JPanel();
    private boolean flagaObszaruTekstowego = false;
    private String przedZmianaObszaruTekstowego = "";

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
