package okna;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame  implements WindowListener  {


    public Main() {
        initComponents();
    }
    public void initComponents() {
        this.setTitle("");
        this.setSize(600,600);
//        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(3);
        this.getContentPane().add(panel);
        panel.add(noweOkno);
        noweOkno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new nowaRamka().setVisible(true);           ///!!!! najważniejsza częśc tego tutoraiala
            }
        });
        this.pack();


    }

    private JPanel panel = new JPanel();
    private JFrame okno1 = this;
   private JButton noweOkno = new JButton("dodaj okno");


    public static void main(String[] args) {
        new Main().setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e) {
        JOptionPane.showMessageDialog(rootPane, "witaj:)");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        int opcja = JOptionPane.showConfirmDialog(rootPane, "na pewno?");
        if (opcja ==0) {
            this.dispose();
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //tutaj zapisujemy dane po zamknięciu do bazy danych
    }

    @Override
    public void windowIconified(WindowEvent e) {        //minimalizacja

    }

    @Override
    public void windowDeiconified(WindowEvent e) {      //maksymalizacja

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}

